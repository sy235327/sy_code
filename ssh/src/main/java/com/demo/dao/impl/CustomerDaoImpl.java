package com.demo.dao.impl;

import com.demo.dao.CustomerDao;
import com.demo.entity.Customer;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

    @Override
    public Customer findById(Long id) {
        return this.getHibernateTemplate().get(Customer.class,id);
    }
}
