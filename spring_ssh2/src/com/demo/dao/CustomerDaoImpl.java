package com.demo.dao;

import com.demo.domain.Customer;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 持久层
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
    /**
     * 保存客户
     */
    @Override
    public void save(Customer customer) {
        System.out.println("持久层 保存客户...");
        //获取模板类对象,把数据,保存到数据库中
        this.getHibernateTemplate().save(customer);
        System.out.println(customer);
    }
}
