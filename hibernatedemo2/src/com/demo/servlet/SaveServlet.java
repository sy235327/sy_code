package com.demo.servlet;

import com.demo.domain.User;
import com.demo.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2018/3/14.
 */
@WebServlet(name = "SaveServlet",urlPatterns = "/save")
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u1 = new User();
        User u2 = new User();
        u1.setName("测试1");
        u2.setName("测试2");
        new UserService().save(u1,u2);
    }
}
