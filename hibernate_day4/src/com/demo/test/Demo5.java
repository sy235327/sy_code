package com.demo.test;

import com.demo.domain.Linkman;
import com.demo.utils.HibernateUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * SQL的查询的方式
 */
public class Demo5 {
    /**
     * 把数据封装到对象中
     */
    @Test
    public void run2(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建SQL的查询的接口
        SQLQuery sqlQuery = session.createSQLQuery("select * from cst_linkman");
        //通过方法设置
        sqlQuery.addEntity(Linkman.class);
        List<Linkman> list = sqlQuery.list();
        for (Linkman linkman : list){
            System.out.println(linkman);
        }

        tr.commit();
    }
    /**
     * 测试SQL语句的查询
     */
    @Test
    public void run1(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建SQL的查询的接口
        SQLQuery sqlQuery = session.createSQLQuery("select * from cst_linkman");
        //hibernate是操作对象就相当于操作数据库,但是直接查询数据表返回的是Object[]数组存储数据,数据并没有封装到javabean
        List<Object[]> list = sqlQuery.list();
        for (Object[] objects : list){
            System.out.println(Arrays.toString(objects));
        }

        tr.commit();
    }
}
