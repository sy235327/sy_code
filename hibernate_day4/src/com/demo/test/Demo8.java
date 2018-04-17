package com.demo.test;

import com.demo.domain.Customer;
import com.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

/**
 * 查询的策略
 */
public class Demo8 {
    /**
     * fetch: subselect  子查询的方式
     * lazy:extra 极其延迟加载
     */
    @Test
    public void run7(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        List<Customer> list = session.createQuery("from Customer").list();
        for (Customer customer:list){
            System.out.println(customer);
        }

        tr.commit();
    }
    /**
     * fetch: subselect  子查询的方式
     * lazy:false 不延迟加载
     */
    @Test
    public void run6(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        List<Customer> list = session.createQuery("from Customer").list();
        for (Customer customer:list){
            System.out.println(customer);
        }

        tr.commit();
    }
    /**
     * fetch: subselect  子查询的方式
     * lazy:true 延迟加载
     */
    @Test
    public void run5(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        List<Customer> list = session.createQuery("from Customer").list();
        for (Customer customer:list){
            System.out.println(customer);
        }

        tr.commit();
    }
    /**
     * fetch: join  发送迫切查询
     * lazy:什么值都是一样的效果
     */
    @Test
    public void run4(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //查询客户
        Customer customer = session.get(Customer.class, 1L);

        //查询客户下面的联系人
        System.out.println(customer.getLinkmans().size());

        tr.commit();
    }
    /**
     * fetch: select   发送查询语句
     * lazy: extra      极其延迟加载
     */
    @Test
    public void run3(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //查询客户
        Customer customer = session.get(Customer.class, 1L);

        //查询客户下面的联系人
        System.out.println(customer.getLinkmans().size());

        tr.commit();
    }
    /**
     * fetch: select   发送查询语句
     * lazy: false       不延迟加载
     */
    @Test
    public void run2(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //查询客户
        Customer customer = session.get(Customer.class, 1L);

        //查询客户下面的联系人
        System.out.println(customer.getLinkmans().size());

        tr.commit();
    }
    /**
     * 默认值:
     * fetch: select   发送查询语句
     * lazy: true       延迟加载
     */
    @Test
    public void run1(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //查询客户
        Customer customer = session.get(Customer.class, 1L);

        //查询客户下面的联系人
        System.out.println(customer.getLinkmans().size());

        tr.commit();
    }
}
