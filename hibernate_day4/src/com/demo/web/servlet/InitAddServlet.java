package com.demo.web.servlet;

import com.demo.domain.Customer;
import com.demo.service.CustomerService;

import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "InitAddServlet",urlPatterns = "/initAdd")
public class InitAddServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        List<Customer> list = new CustomerService().findAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/jsp/linkman/add.jsp").forward(request,response);
    }
}
