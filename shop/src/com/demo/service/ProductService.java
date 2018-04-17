package com.demo.service;

import com.demo.dao.ProductDao;
import com.demo.domain.Category;
import com.demo.domain.PageBean;
import com.demo.domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * service
 */
public class ProductService {

    /**
     * 获取热门商品
     * @return 热门商品
     */
    public List<Product> findHotProductList() {
        ProductDao dao = new ProductDao();
        List<Product> hotProductList = null;
        try {
            hotProductList = dao.findHotProductList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotProductList;
    }

    /**
     * 获取最新商品
     * @return 最新商品
     */
    public List<Product> findNewProductList() {
        ProductDao dao = new ProductDao();
        List<Product> newProductList = null;
        try {
            newProductList = dao.findNewProductList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newProductList;
    }

    /**
     * 获取分类数据
     * @return 分类数据
     */
    public List<Category> findAllCategory() {
        ProductDao dao = new ProductDao();
        List<Category> categoryList = null;
        try {
            categoryList = dao.findAllCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    /**
     * 分页功能
     * @param cid 分类id
     * @return 分页数据和商品数据
     */
    public PageBean findProductListByCid(String cid,int currentPage,int currentCount) {
        ProductDao dao = new ProductDao();

        //封装一个PageBean 返回web层
        PageBean<Product> pagebean = new PageBean<Product>();

        //1.封装当前页
        pagebean.setCurrentPage(currentPage);

        //2.封装每页显示的商品个数
        pagebean.setCurrentCount(currentCount);

        //3.封装商品总条数
        int totalCount = 0;
        try {
             totalCount = dao.getCount(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pagebean.setTotalCount(totalCount);

        //4.封装总页数
        /*double d = totalCount%currentCount;
        int i = totalCount%currentCount;
        //判断是否能整除
        i = d==0 ? i:i++;*/
        //调用工具类,返回最大的值(有小数就返回最大的整数)
        int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
        pagebean.setTotalPage(totalPage);

        //5.封装当前页面商品信息,调用dao层 传递 cid:类别  limit: index:起始,currentCount:多少个
        //当前页与开始索引index的关系
        int index = (currentPage-1)*currentCount;
        List<Product> list = null;
        try {
            list = dao.findProductBtPage(cid,index,currentCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pagebean.setList(list);

        return pagebean;
    }

    /**
     * 通过pid获取商品信息
     * @param pid 商品id
     * @return 商品信息
     */
    public Product findProductByPid(String pid) {
        ProductDao dao = new ProductDao();
        Product productDao = null;
        try {
            productDao = dao.findProductByPid(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productDao;
    }
}
