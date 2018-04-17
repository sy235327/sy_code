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

    //提供service的成员属性,提供set方法,struts2-spring的jar包的struts-plugin.xml常量配置根据属性名称查找applicationContext.xml中的bean配置是否有对应名称如果有就自动注入
    private CustomerService customerService;

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

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
        /*WebApplicationContext webContext = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
        CustomerService service = (CustomerService) webContext.getBean("customerService");*/

        //调用方法
        customerService.save(customer);

        return NONE;
    }



}
