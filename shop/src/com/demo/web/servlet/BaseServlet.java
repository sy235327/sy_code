package com.demo.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * servlet抽取
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");

        try {
            //1.获取得请求的method的名称
            String methodName = req.getParameter("method");
            System.out.println(methodName);

            //2. 获取当前访问的对象的字节码对象,(当前那个对象访问,this就是那个对象)
            Class clazz = this.getClass(); //ProductServlet.class     UserServlet.class

            //3.获取当前字节码对象中的指定方法
            Method method = clazz.getMethod(methodName,HttpServletRequest.class, HttpServletResponse.class);

            //4.执行指定方法 当前访问的对象 this
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
