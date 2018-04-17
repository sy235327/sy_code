package com.demo.dao;

import com.demo.domain.Customer;
import com.demo.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * dao
 */
public class CustomerDao {

    /**
     * 保存客户
     * @param c 客户信息
     */
    public void save(Customer c){
        //先获取session
        Session session = HibernateUtils.getSession();

        //开启事务
        Transaction tr = session.beginTransaction();

        //保存用户
        session.save(c);

        //提交事务
        tr.commit();

        //关闭资源
        session.close();
    }

    /**
     * 查询所有客户
     * @return
     */
    public List<Customer> findAll(){
        //获取session
        Session session = HibernateUtils.getCurrentSession();

        //QBC查询
        Criteria criteria = session.createCriteria(Customer.class);
        //查询
        List<Customer> list = criteria.list();

        return list;
    }

    /**
     * 查询所有客户
     * 带查询条件的
     * @return
     */
    public List<Customer> findAll(String custName){
        //获取session
        Session session = HibernateUtils.getCurrentSession();

        //QBC查询
        Criteria criteria = session.createCriteria(Customer.class);

        //添加查询条件
        if (custName != null && !custName.trim().isEmpty()){
            //添加查询条件
            criteria.add(Restrictions.like("cust_name","%"+custName+"%"));
        }

        //查询
        List<Customer> list = criteria.list();

        return list;
    }
}
