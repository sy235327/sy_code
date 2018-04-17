package com.demo.web.servlet;

import com.demo.domain.User;
import com.demo.service.UserService;
import com.demo.utils.CommonsUtils;
import com.demo.utils.MailUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * 抽取
 */
@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends BaseServlet {
    /**
     * 完成用户激活
     */
    public void actice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取激活码
        String activeCode = request.getParameter("activeCode");

        //2.调用service层
        UserService service = new UserService();
        boolean active= service.active(activeCode);

        //3.判断是否成功
        if (active){
            //成功: 跳转到登陆页面
            response.sendRedirect(request.getContextPath()+"/login.jsp");

        }else{
            //跳转到失败页面
            response.sendRedirect(request.getContextPath()+"/404.jsp");
        }
    }

    /**
     * 判断用户名是否存在
     */
    public void checkUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        //调用service层,传递用户名
        UserService service = new UserService();
        boolean isExist = service.checkUsername(username);

        //响应结果 json格式
        String json = "{\"isExist\":"+isExist+"}";
        response.getWriter().print(json);
    }

    /**
     * 生成一张验证码
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void code(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 使用java图形界面技术绘制一张图片

        int charNum = 4;
        int width = 30 * 4;
        int height = 30;

        // 1. 创建一张内存图片
        BufferedImage bufferedImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        // 2.获得绘图对象
        Graphics graphics = bufferedImage.getGraphics();

        // 3、绘制背景颜色
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(0, 0, width, height);

        // 4、绘制图片边框
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0, 0, width - 1, height - 1);

        // 5、输出验证码内容
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("宋体", Font.BOLD, 20));

        // 随机输出4个字符
        Graphics2D graphics2d = (Graphics2D) graphics;
        String s = "ABCDEFGHGKLMNPQRSTUVWXYZ23456789";
        Random random = new Random();
        //session中要用到
        String msg="";
        int x = 5;
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(32);
            String content = String.valueOf(s.charAt(index));
            msg+=content;
            double theta = random.nextInt(45) * Math.PI / 180;
            //让字体扭曲
            graphics2d.rotate(theta, x, 18);
            graphics2d.drawString(content, x, 18);
            graphics2d.rotate(-theta, x, 18);
            x += 30;
        }

        //将验证码放入session中
        HttpSession session = request.getSession();
        session.setAttribute("codesession",msg);

        // 6、绘制干扰线
        graphics.setColor(Color.GRAY);
        for (int i = 0; i < 5; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);

            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1, y1, x2, y2);
        }

        // 释放资源
        graphics.dispose();

        // 图片输出 ImageIO
        ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
    }

    /**
     * 用户注册
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //获取验证码 判断是否正确,错误跳转回注册页面并提示
        //用户提交的验证码
        String checkCode = request.getParameter("checkCode");

        //session中的验证码
        HttpSession session = request.getSession();
        String codesession = (String) session.getAttribute("codesession");

        //一次性验证码,获取完后删除
        request.getSession().removeAttribute("codesession");

        //判断验证码是否正确.不正确跳转回注册页面
        if (!codesession.equals(checkCode)){
            //request域对象,放入错误提示,请求转发到注册页面
            request.setAttribute("msg",1);

            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }

        //2.获取表单数据
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            //自己指定一个类型转换器(将String转换为Date)
            // :BeanUtils调用方法给对象赋值,赋的时转换器返回的值,转换器可以指定一个javabean中属性指定类型的值都为转换器返回的值
            ConvertUtils.register(new Converter() {
                @Override
                public Object convert(Class aClass, Object value) {
                    //将String转成Date
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date parse = null;
                    try {
                        parse = format.parse(value.toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return parse;
                }
            }, Date.class);
            //使用BeanUtils工具类映射封装数据
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //下面这些数据由我们传递
        //private String uid;
        user.setUid(CommonsUtils.getUUID());

        //private String telephone;
        user.setTelephone(null);

        //private int state; 是否激活
        user.setState(0);// 0表示未激活,1表示激活

        //private String code; 激活码
        String code = CommonsUtils.getUUID();
        user.setCode(code);

        //3.将user传递给service层
        UserService service = new UserService();
        boolean isRegisterSuccess = service.register(user);

        //4.是否注册成功
        if (isRegisterSuccess){
            //发送激活邮件
            String emailMsg = "恭喜您注册成功,请点击下面的链接进行激活账户" +
                    "<a href='http://localhost/shop/user?method=active&activeCode="+code
                    +"'>http://localhost/shop/user?method=active&activeCode"+code+"</a>";
            try {
                MailUtils.sendMail(user.getEmail(),emailMsg);
            } catch (MessagingException e) {
                e.printStackTrace();
            }

            //跳转到注册成功页面
            response.sendRedirect(request.getContextPath()+"/registerSuccess.jsp");
        }else{
            //跳转到,注册失败页面
            response.sendRedirect(request.getContextPath()+"/registerFail.jsp");
        }

    }

    /**
     * 登陆用户
     * @param request 请求
     * @param response 响应
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建service层
        UserService service = new UserService();
        //获取用户输入的验证码
        String usercode = request.getParameter("code");
        //获取session中的验证码
        String code = (String) request.getSession().getAttribute("codesession");
        //判断验证码
        if (code.equals(usercode)){
            //获取用户名和密码
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            //调用service层判断用户名和密码是否正确
            boolean ExisUser = service.login(username,password);
            if (ExisUser){
                //将用户名和密码放入session中
                request.getSession().setAttribute(username,password);
                //判断用户是否点击自动登陆
                String relogin = request.getParameter("relogin");
                if ("relogin".equals(relogin)){
                    //如果点击了自动登陆将用户账号和密码放入cookie中
                    Cookie userandpasswordcookie = new Cookie(username,password);
                    response.addCookie(userandpasswordcookie);
                }
                //判断用户是否点击记住用户名
                String reuser = request.getParameter("reuser");
                if ("reuser".equals(reuser)){
                    //如果点击将用户名放入cookie中
                    Cookie usercookie = new Cookie("user",username);
                    response.sendRedirect(usercode);
                }
                //重定向到index
                response.sendRedirect(request.getContextPath()+"/product?method=index");

            }else{
                request.setAttribute("msg","密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }else{
            request.setAttribute("msg","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

}
