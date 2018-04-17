package com.demo.service.Impl;

import com.demo.dao.CustomerDao;
import com.demo.entity.Customer;
import com.demo.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public Customer findById(Long id) {
        return customerDao.findById(id);
    }
}
