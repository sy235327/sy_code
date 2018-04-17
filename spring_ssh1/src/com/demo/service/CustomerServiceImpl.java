package com.demo.service;

import com.demo.domain.Customer;

/**
 * 客户的业务层
 */
public class CustomerServiceImpl implements CustomerService {


    /**
     * 保存客户
     */
    @Override
    public void save(Customer customer) {
        System.out.println("业务层保存客户...");
        System.out.println(customer);
    }
}
