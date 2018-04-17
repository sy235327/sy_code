package com.demo.test;

import com.demo.domain.Linkman;
import com.demo.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;

public class Demo4 {
    /**
     * 演示离线条件对象
     */
    @Test
    public void run3(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //创建离线条件查询的对象(不需要通过session创建)
        DetachedCriteria criteria = DetachedCriteria.forClass(Linkman.class);
        //添加查询的条件
        criteria.add(Restrictions.eq("lkm_id",1L));

        //查询
        List<Linkman> list = criteria.getExecutableCriteria(session).list();
        for (Linkman linkman:list){
            System.out.println(linkman);
        }

        tr.commit();
    }

    /**
     * 清除聚合函数
     */
    @Test
    public void run2(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建QBC查询接口
        Criteria criteria = session.createCriteria(Linkman.class);

        //设置聚合函数的方式
        criteria.setProjection(Projections.count("lkm_id"));

        //sql返回结果
        List<Number> list = criteria.list();

        long count = list.get(0).longValue();

        System.out.println(count);

        //如果上面设置了聚合函数,需要在设置一次聚合函数setProjection方法,否则查询到的还是聚合函数
        criteria.setProjection(null);

        //继续查询所有的联系人
        List<Linkman> mans = criteria.list();
        for (Linkman linkman : mans){
            System.out.println(linkman);
        }
        tr.commit();
    }
    /**
     * 聚合函数
     */
    @Test
    public void run1(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建QBC查询接口
        Criteria criteria = session.createCriteria(Linkman.class);

        //设置聚合函数的方式
        List<Number> list = criteria.setProjection(Projections.count("lkm_id")).list();

        long count = list.get(0).longValue();

        System.out.println(count);

        tr.commit();
    }
}
