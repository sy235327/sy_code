package com.demo.test;

import com.demo.domain.Customer;
import com.demo.domain.Linkman;
import com.demo.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * HQL的多表查询
 */
public class Demo6 {
    /**
     * 数据的重复的问题
     * HQL查询
     */
    @Test
    public void run3(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //内连接的查询
        Query query = session.createQuery("from Customer c inner join fetch c.linkmans");

        //默认的返回值是数组
        List<Customer> list = query.list();
        //存储到set集合,让数据不重复
        Set<Customer> set = new HashSet<Customer>(list);
        for (Customer customer : set){
            System.out.println(customer);
        }

        tr.commit();
    }
    /**
     * 数据默认返回的数组,把数据封装到对象中
     * 提供关键字: fetch 迫切连接,使用fetch关键字,把数据封装到对象中
     */
    @Test
    public void run2(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //内连接的查询
        Query query = session.createQuery("from Customer c inner join fetch c.linkmans");

        //默认的返回值是数组
        List<Customer> list = query.list();
        for (Customer customer : list){
            System.out.println(customer);
        }

        tr.commit();
    }
    /**
     * 查询的客户,客户和联系人有关联
     * select * from cst_customer c,cst_linkman l where c.id = l.id
     */
    @Test
    public void run1(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //内连接的查询
        Query query = session.createQuery("from Customer c inner join c.linkmans");

        //默认的返回值是数组
        List<Object[]> list = query.list();
        for (Object[] objects : list){
            System.out.println(Arrays.toString(objects));
        }

        tr.commit();
    }
}
