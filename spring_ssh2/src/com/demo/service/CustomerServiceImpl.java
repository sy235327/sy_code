package com.demo.service;

import com.demo.dao.CustomerDao;
import com.demo.domain.Customer;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 * 客户的业务层
 */
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    /**
     * 保存客户
     */
    @Override
    public void save(Customer customer) {
        System.out.println("业务层保存客户...");
        customerDao.save(customer);
    }
}
