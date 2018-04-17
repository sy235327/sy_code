package com.demo.service;

import com.demo.dao.CustomerDao;
import com.demo.domain.Customer;
import com.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

/**
 * 客户的业务层
 */
public class CustomerService {
    /**
     * 保存客户
     * @param customer
     */
    public void saveCustomer(Customer customer){
        //开启事务
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        try {
            //调用业务层
            new CustomerDao().save(customer);
            tr.commit();
        }catch(Exception e){
            System.out.println("保存失败");
            tr.rollback();
        }
    }

    /**
     * 测试
     */
    @Test
    public void run1(){
        Customer customer = new Customer();
        customer.setCust_name("测试");
        this.saveCustomer(customer);
    }

    /**
     * 查询所有的客户
     * @Parameter List<Customer> 所有客户信息
     */
    public List<Customer> findAll(){
        Session session = HibernateUtils.getCurrentSession();
        try {
            //开启事务
            session.beginTransaction();
            //调用service层
            List<Customer> list = new CustomerDao().findAll();
            session.beginTransaction().commit();
            return list;
        }catch(Exception e){
            //回滚事务
            session.beginTransaction().rollback();
            return null;
        }

    }
}
