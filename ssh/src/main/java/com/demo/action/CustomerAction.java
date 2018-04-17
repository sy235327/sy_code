package com.demo.action;

import com.demo.entity.Customer;
import com.demo.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 客户模块的action
 */
public class CustomerAction extends ActionSupport {
//    private CustomerService customerService;
    private Long custId;

    private Customer customer;

    private CustomerService customerService;

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        custId = custId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public String findById(){
        customer = customerService.findById(custId);
        return SUCCESS;
//        System.out.println("OK");
//        return NONE;
    }
}
