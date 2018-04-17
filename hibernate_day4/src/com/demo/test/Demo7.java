package com.demo.test;

import com.demo.domain.Customer;
import com.demo.utils.HibernateUtils;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

/**
 * 演示延迟加载,提升程序性能
 */
public class Demo7 {
    /**
     * fetch属性能解决的问题
     */
    @Test
    public void run4(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //查询客户
        List<Customer> list = session.createQuery("from Customer").list();

        //每个客户联系人的个数
        for (Customer customer : list){
            System.out.println(customer.getLinkmans().size());
        }

        tr.commit();
    }
    /**
     * 关联级别的延迟加载,不想延迟加载可以配置lazy属性
     * 客户下的联系人的集合
     */
    @Test
    public void run3(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //先查询1号客户
        Customer customer = session.get(Customer.class, 1L);
        System.out.println("==============================");

        //看客户下所有的联系人
        System.out.println(customer.getLinkmans().size());

        tr.commit();
    }
    /**
     * 类级别的延迟加载
     * 需要使用session.load() 默认情况使用的延迟加载
     */
    @Test
    public void run2(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //使用load方法,默认是延迟加载
        Customer customer = session.load(Customer.class, 1L);

        //把customer对象初始化,不再延迟加载,直接加载
        Hibernate.initialize(customer);

        System.out.println("======================");
        System.out.println(customer.getCust_name());

        tr.commit();
    }

    /**
     * 类级别的延迟加载
     * 需要使用session.load() 默认情况使用的延迟加载
     */
    @Test
    public void run1(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //使用get方法
        Customer customer = session.get(Customer.class, 1L);
        System.out.println("======================");
        System.out.println(customer.getCust_name());

        tr.commit();
    }
}
