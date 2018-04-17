package com.demo.test;

import com.demo.domain.Customer;
import com.demo.domain.Linkman;
import com.demo.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * QBC的查询
 */
public class Demo3 {
    /**
     * 判断值是否为空
     */
    @Test
    public void run7(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //创建QBC查询接口
        Criteria criteria = session.createCriteria(Linkman.class);

        //找所有的lkm_email是空的值
        criteria.add(Restrictions.isNull("lkm_email"));

        //获取数据
        List<Linkman> list = criteria.list();

        for (Linkman linkman : list){
            System.out.println(linkman);
        }

        tr.commit();
    }
    /**
     * 演示QBC的or方法
     */
    @Test
    public void run6(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //创建QBC查询接口
        Criteria criteria = session.createCriteria(Linkman.class);

        //SQL: select * from cst_linkman where lkm_gender='女' or lkm_id = 3L;
        criteria.add(Restrictions.or(Restrictions.eq("lkm_gender","女"),Restrictions.eq("lkm_id",3L)));

        //获取数据
        List<Linkman> list = criteria.list();

        for (Linkman linkman : list){
            System.out.println(linkman);
        }

        tr.commit();
    }

    /**
     * in (数据,数据) 包含此数据条件
     */
    @Test
    public void run5(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //创建QBC查询接口
        Criteria criteria = session.createCriteria(Linkman.class);

        // SQL: select * from cst_linkman where lkm_id in (1,2,7);
        List<Long> params = new ArrayList<Long>();
        params.add(1L);
        params.add(2L);
        params.add(7L);

        //使用in 方法查询
        criteria.add(Restrictions.in("lkm_id",params));

        //获取数据
        List<Linkman> list = criteria.list();

        for (Linkman linkman : list){
            System.out.println(linkman);
        }

        tr.commit();
    }

    /**
     * 条件查询
     * between  在什么之间
     */
    @Test
    public void run4(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //创建QBC查询接口
        Criteria criteria = session.createCriteria(Linkman.class);

        //使用方法添加条件 添加两个条件默认使用and添加多个条件
        //criteria.add(Restrictions.eq("lkm_gender","女"));
        //criteria.add(Restrictions.ge("lkm_id",3L));

        //在什么之间
        criteria.add(Restrictions.between("lkm_id",2L,5L));

        //获取数据
        List<Linkman> list = criteria.list();

        for (Linkman linkman : list){
            System.out.println(linkman);
        }

        tr.commit();
    }
    /**
     * QBC分页的方法和HQL分页的方式一样
     */
    @Test
    public void run3(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //创建QBC查询接口
        Criteria criteria = session.createCriteria(Linkman.class);
        //调用排序的方法 addOrder.desc("lkm_id");
        criteria.addOrder(Order.desc("lkm_id"));

        //设置分页的方法
        criteria.setFirstResult(0);
        criteria.setMaxResults(3);

        //获取数据
        List<Linkman> list = criteria.list();

        for (Linkman linkman : list){
            System.out.println(linkman);
        }

        tr.commit();
    }
    /**
     * QBC的查询
     * 排序查询
     */
    @Test
    public void run2(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //创建QBC查询接口
        Criteria criteria = session.createCriteria(Linkman.class);
        //调用排序的方法,addOrder()
        criteria.addOrder(Order.desc("lkm_id"));
        List<Linkman> list =  criteria.list();
        for (Linkman l : list){
            System.out.println(l);
        }

        tr.commit();
    }

    /**
     * QBC的基础入门查询
     */
    @Test
    public void run1(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //创建QBC查询接口
        Criteria criteria = session.createCriteria(Customer.class);
        List<Customer> list =   criteria.list();
        for (Customer c : list){
            System.out.println(c);
        }

        tr.commit();
    }
}
