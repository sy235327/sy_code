package com.demo.action;

import com.demo.domain.Customer;
import com.demo.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;

import java.util.List;

/**
 * 客户模块的控制器
 * 使用Model方式封装数据到javabean
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
    //手动实例化客户javabean
    private Customer customer = new Customer();

    /**
     * @return 返回客户javabean
     */
    @Override
    public Customer getModel() {
        return customer;
    }

    /**
     * 保存客户
     * @return
     */
    public String save(){
        new CustomerService().saveCustomer(customer);
        return SUCCESS;
    }

    /**
     * 查询所有的客户
     * @return
     */
    public String list(){
        List<Customer> list = new CustomerService().findAll();
        //获取值栈
        ValueStack stack = ServletActionContext.getContext().getValueStack();
        //压栈,默认的规范:压入的是集合,一般使用set方法,压入是对象,使用push对象
        stack.set("list",list);
        return "list";
    }

}
