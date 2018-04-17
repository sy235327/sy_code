package com.demo.web.servlet;

import com.demo.domain.Customer;
import com.demo.service.CustomerService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 添加客户的控制器
 * servlet
 */
@WebServlet(name = "SaveCustomerServlet",urlPatterns = "/saveCustomer")
public class SaveCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //接受请求的参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println(parameterMap);

        //封装数据，使用BeanUtils工具，导入jar包
        Customer cust = new Customer();
        try {
            BeanUtils.populate(cust,parameterMap);

            //调用业务层
            new CustomerService().saveCustomer(cust);
            System.out.println("添加客户成功");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
