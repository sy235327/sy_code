package com.demo.dao;

import com.demo.entity.Customer;

public interface CustomerDao {
    /**
     * 根据id获取客户信息
     * @param id
     * @return
     */
    Customer findById(Long id);
}
