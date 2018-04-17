package com.demo.test;

import com.demo.domain.Linkman;
import com.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * 在many-to-one标签上 查询策略的优化
 */
public class Demo9 {
    /**
     * fetch : join 左链接查询
     * lazy:值都一样
     */
    @Test
    public void run3(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        Linkman linkman = session.get(Linkman.class, 1L);

        //看联系人的客户名称
        System.out.println(linkman.getCustomer().getCust_name());

        tr.commit();
    }
    /**
     * fetch : select
     * lazy: proxy 看一方的lazy配置是什么就是什么值
     */
    @Test
    public void run2(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        Linkman linkman = session.get(Linkman.class, 1L);

        //看联系人的客户名称
        System.out.println(linkman.getCustomer().getCust_name());

        tr.commit();
    }
    /**
     * 默认值
     * fetch : select
     * laze: 是延迟加载
     */
    @Test
    public void run1(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        Linkman linkman = session.get(Linkman.class, 1L);

        //看联系人的客户名称
        System.out.println(linkman.getCustomer().getCust_name());

        tr.commit();
    }
}
