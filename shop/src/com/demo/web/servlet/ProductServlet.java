package com.demo.web.servlet;

import com.demo.domain.Category;
import com.demo.domain.PageBean;
import com.demo.domain.Product;
import com.demo.service.ProductService;
import com.demo.utils.JedisPoolUtils;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * servlet抽取
 * 第一层抽取,将servlet全部抽取为函数
 *
 * 第二层抽取,重写HttpServlet类的service方法(service方法才判断请求方式分为get和post),直接调用第一层抽取好的函数
 */
@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends BaseServlet {

/*
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取method参数
        String method = request.getParameter("method");

        //判断method参数,对应的参数调用对应的方法
        switch(method){
            case "cateGoryList":
                cateGoryList(request,response);
                break;
            case "index":
                index(request,response);
                break;
            case "productInfo":
                productInfo(request,response);
                break;
            case "productList":
                productList(request,response);
                break;
            default :
                error(request,response);
                break;
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
*/

    /**
     * 分类数据
     */
    public void cateGoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService service = new ProductService();

        //先从缓存中查询categoryList,如果有直接使用返回.没有再从数据库中查询,存到缓存中
        //1.获得jedis对象,连接redis数据库
        Jedis jedis = JedisPoolUtils.getJedis();
        String categoryListJson = jedis.get("categoryListJson");

        //2.判断 categoryListJson 是否为空
        if (categoryListJson == null) {
            //如果为空则获取数据库中的分类数据存储到redis数据库中

            //获取分类数据
            List<Category> allCategory = service.findAllCategory();

            //将数据格式改为json格式,使用Gson.jar包 工具类转换
            Gson gson = new Gson();
            categoryListJson = gson.toJson(allCategory);

            jedis.set("categoryListJson", categoryListJson);
        }
        //响应回ajax
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(categoryListJson);
    }

    /**
     * 实现动态的热门商品和最新上商品
     */
    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService service = new ProductService();

        //准备热门商品---,返回List<Product>
        List<Product> hotProductList = service.findHotProductList();

        //准备最新商品---,返回List<Product>
        List<Product> newProductList = service.findNewProductList();

        //准备分类数据---,返回List<>,跟换ajax获取
        //List<Category> categoryList = service.findAllCategory();

        request.setAttribute("hotProductList", hotProductList);
        request.setAttribute("newProductList", newProductList);
        //request.setAttribute("categoryList",categoryList);

        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }

    /**
     * 获取指定商品信息
     */
    public void productInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取当前页
        String currentPage = request.getParameter("currentPage");

        //获取商品类别
        String cid = request.getParameter("cid");

        //获取要查询商品的pid,当前查看的商品pid
        String pid = request.getParameter("pid");

        ProductService service = new ProductService();
        Product product = service.findProductByPid(pid);

        request.setAttribute("product", product);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("cid", cid);

        //获取客户端携带的cookies---获得名字是pids的cookie
        String pids = pid;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            //遍历cookies
            for (Cookie cookie : cookies) {

                //判断是否为cookie名称是否为 pids
                if ("pids".equals(cookie.getName())) {
                    //重新赋值pids,拼接字符
                    pids = cookie.getValue();

                    //1-2-3 pid之间使用-隔离,
                    //判断pids中是否已有pid
                    //将pids拆成数组,转为集合
                    String[] splits = pids.split("-");
                    List<String> stringsList = Arrays.asList(splits);
                    LinkedList<String> splitsList = new LinkedList<String>(stringsList);

                    //判断集合中是否存在pid,如果存在删除已存在的pid
                    if (splitsList.contains(pid)) {
                        //集合中存在pid
                        splitsList.remove(pid);
                    }

                    //在集合前面添加一个pid
                    splitsList.addFirst(pid);

                    //将集合转为字符串使用-作为分割
                    String sb = "";
                    //限制一下sb长度,最多只能添加7个
                    for (int i = 0; i < splitsList.size() && i < 7; i++) {
                        sb += splitsList.get(i);
                        sb += "-"; // 1-2-3-
                    }

                    //去掉字符串"1-2-3-" 最后一个分割符 "-"
                    pids = sb.substring(0, sb.length() - 1);
                }
            }
        }

        //当在转发之前 创建cookie存储pid
        Cookie c = new Cookie("pids", pids);
        response.addCookie(c);

        request.getRequestDispatcher("/product_info.jsp").forward(request, response);
    }

    /**
     * 根据cid获取分类下面的商品信息
     */
    public void productList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //接受参数 cid,页数
        String cid = request.getParameter("cid");
        String currentPageStr = request.getParameter("currentPage");
        //判断currentPageStr 页数,是否为空,如果为空,调用第一页
        if (currentPageStr == null) {
            currentPageStr = "1";
        }

        //当前页数,将字符串格式转为int格式
        int currentPage = Integer.parseInt(currentPageStr);
        //每页显示的商品个数
        int currentCount = 12;

        //service层
        ProductService service = new ProductService();
        PageBean pageBean = service.findProductListByCid(cid, currentPage, currentCount);

        //将分类下面的商品信息放入request请求域对象中
        request.setAttribute("pageBean", pageBean);
        request.setAttribute("cid", cid);

        //定义一个集合,用于存储历史记录的商品信息
        List<Product> historyProductList = new ArrayList<Product>();

        //获取客户端携带名称为 pids的cookies
        Cookie[] cookies = request.getCookies();
        //判断cookies是为空
        if (cookies != null) {
            //遍历cookie数组
            for (Cookie cookie : cookies) {
                //判断cookie名称是否为指定名称
                if ("pids".equals(cookie.getName())) {
                    //获取cookie名称为 pids的值
                    String pids = cookie.getValue();
                    //拆分字符串
                    String[] splits = pids.split("-");
                    //遍历商品pid 调用service查询
                    for (String pid : splits) {
                        Product productByPid = service.findProductByPid(pid);
                        historyProductList.add(productByPid);
                    }
                }
            }
        }

        //将历史记录的集合放入域中
        request.setAttribute("historyProductList", historyProductList);


        //请求转发
        request.getRequestDispatcher("/product_list.jsp").forward(request, response);
    }

    /**
     * 错误页面
     *
     * @param request  请求
     * @param response 响应
     * @throws ServletException
     * @throws IOException
     */
    public void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/404.jsp").forward(request, response);
    }


    /**
     * 将商品添加到购物车
     * @param request 请求
     * @param response 响应
     * @throws ServletException
     * @throws IOException
     */
    public void addProductToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService service = new ProductService();
        //获取商品pid
        String pid = request.getParameter("pid");
        //获取该商品的购买数量
        String buyNum = request.getParameter("buyNum");

        //获取商品信息 封装到product对象中
        Product product = service.findProductByPid(pid);

        //计算小计
        double subtotal = product.getShop_price()* Double.valueOf(buyNum);

    }
}