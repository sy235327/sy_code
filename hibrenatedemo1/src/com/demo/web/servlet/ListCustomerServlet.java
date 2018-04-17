package com.demo.web.servlet;

import com.demo.domain.Customer;
import com.demo.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 查询所有的客户
 */
@WebServlet(name = "ListCustomerServlet",urlPatterns = "/listCustomer")
public class ListCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        //先获取请求参数   客户名称
        String custName = request.getParameter("custName");

        List<Customer> list = new CustomerService().findAll(custName);


        //存储到request域中
        request.setAttribute("list",list);

        //转发
        request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request,response);
    }
}
