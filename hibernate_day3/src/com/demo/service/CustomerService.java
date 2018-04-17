package com.demo.service;

import com.demo.dao.CustomerDao;
import com.demo.domain.Customer;
import com.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * service层
 */
public class CustomerService {

    /**
     * 保存客户
     * @param c 客户信息
     */
    public void saveCustomer(Customer c){
        new CustomerDao().save(c);
    }

    /**
     * 查询所有的客户
     * @return 返回所有的客户信息
     */
    public List<Customer> findAll(){
        //获取session
        Session session = HibernateUtils.getCurrentSession();
        //开启事务
        Transaction tr = session.beginTransaction();
        List<Customer> list = null;
        try {
            list = new CustomerDao().findAll();
            //提交事务
            tr.commit();
        }catch(Exception e) {
            //回滚事务
            tr.rollback();
        }finally {
            return list;
        }
    }

    /**
     * 查询所有的客户
     * 带查询条件的
     * @return 返回所有的客户信息
     */
    public List<Customer> findAll(String custName){
        //获取session
        Session session = HibernateUtils.getCurrentSession();
        //开启事务
        Transaction tr = session.beginTransaction();
        List<Customer> list = null;
        try {
            list = new CustomerDao().findAll(custName);
            //提交事务
            tr.commit();
        }catch(Exception e) {
            //回滚事务
            tr.rollback();
        }finally {
            return list;
        }
    }
}
