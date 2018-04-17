package com.demo.web.action;

import com.demo.domain.Customer;
import com.demo.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 客户的控制层
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

    //模型驱动实例化
    private Customer customer = new Customer();
    @Override
    public Customer getModel() {
        return customer;
    }


    /**
     * 保存客户
     * @return
     */
    public String add(){
        System.out.println("WEB层:保存客户...");
//        System.out.println(customer);

        //WEB的工厂
        WebApplicationContext webContext = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
        CustomerService service = (CustomerService) webContext.getBean("customerService");

        //调用方法
        service.save(customer);

        return NONE;
    }



}
