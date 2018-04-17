package com.demo.dao;

import com.demo.domain.Customer;
import com.demo.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

/**
 * 客户的Dao层
 */
public class CustomerDao {
    /**
     * 保存客户
     * @param customer
     */
    public void save(Customer customer){
        Session session = HibernateUtils.getCurrentSession();
        session.save(customer);
    }

    /**
     * 查询所有的客户
     * @return
     */
    public List<Customer> findAll(){
        Session session = HibernateUtils.getCurrentSession();
        return session.createQuery("from Customer").list();
    }
}
