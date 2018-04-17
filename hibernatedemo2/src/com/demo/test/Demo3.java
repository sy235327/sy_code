package com.demo.test;

import com.demo.domain.User;
import com.demo.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;


import java.util.List;

/**
 * 测试查询
 */
public class Demo3 {
    /**
     * 测试Query的查询接口
     */
    @Test
    public void function1(){
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();

        //查询方式
        Query query = session.createQuery("from User");
        List<User> list = query.list();
        for (User user : list){
            System.out.println(user);
        }

        tr.commit();
        session.close();
    }

    /**
     * 添加查询条件
     */
    @Test
    public void function2(){
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();

        //查询方式
        Query query = session.createQuery("from User where age > ?");

        //设置值
        query.setInteger(0,1);

        //查询
        List<User> list = query.list();

        for (User user : list){
            System.out.println(user);
        }

        tr.commit();
        session.close();
    }

    /**
     * Criteria接口; 条件查询，非常适合
     */
    @Test
    public void function3(){
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();

        //先获取查询的接口
        Criteria criteria = session.createCriteria(User.class);
        //没有添加条件，查询所有的数据
        List<User> list = criteria.list();
        System.out.println(list);

        tr.commit();
        session.close();
    }

    /**
     * Criteria接口; 条件查询，非常适合
     */
    @Test
    public void function4(){
        Session session = HibernateUtils.getSession();
        Transaction tr = session.beginTransaction();

        //获取Criteria接口
        Criteria criteria = session.createCriteria(User.class);
        //添加查询条件 select * form user where age > 1;
        //Criterion 是hibernate提供的条件查询的对象，想传入条件的使用的工具类
        //Restriction提供静态的方法，拼接查询条件  gt是大于，lt是小于
        criteria.add(Restrictions.gt("age",1));

        //继续添加条件
        criteria.add(Restrictions.like("name","%王%"));

        List<User> list = criteria.list();
        System.out.println(list);
        tr.commit();
        session.close();
    }
}
