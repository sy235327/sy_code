package com.demo.service;

import com.demo.entity.Customer;

public interface CustomerService {
    /**
     * 根据id查询客户
     * @param id
     * @return
     */
    Customer findById(Long id);
}
