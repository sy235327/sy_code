package com.demo.test;

import com.demo.domain.Customer;
import com.demo.domain.Linkman;
import com.demo.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 演示HQL的基本查询
 */
public class Demo2 {
    /**
     * 聚合函数: count() sum() avg() max() min()
     */
    @Test
    public void run10(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //查询所有联系人的数量(Number是Long型的父类),sum(数字类型) 不能传递字符串类型
        List<Number> list = session.createQuery("select sum(lkm_id) from Linkman l").list();
        //通过下标取值(Number类型通过xxxValue()函数获取xxx类型)
        int count = list.get(0).intValue();
        System.out.println("求和: "+count);

        tr.commit();
    }

    /**
     * 聚合函数: count() sum() avg() max() min()
     */
    @Test
    public void run9(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //查询所有联系人的数量(Number是Long型的父类)
        List<Number> list = session.createQuery("select count(l) from Linkman l").list();
        //通过下标取值(Number类型通过xxxValue()函数获取xxx类型)
        int count = list.get(0).intValue();
        System.out.println("数量: "+count);

        tr.commit();
    }
    /**
     * 投影查询:只查询几个字段,不是所有字段
     * 第一步:需要在javabean类提供对应的构造方法(需要获取几个字段,添加对应字段的构造方法)
     * 第二步:HQL语句的发生变化
     */
    @Test
    public void run8(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建HQL查询接口
        Query query = session.createQuery("select new Linkman(lkm_name,lkm_gender) from Linkman");

        //调用list()方法,查询,返回Object[]数组 (就是查询对应javabean的对象)
        List<Linkman> list = query.list();

        for (Linkman linkman : list){
            System.out.println(linkman);
        }

        tr.commit();
    }

    /**
     * 投影查询:只查询几个字段,不是所有字段
     */
    @Test
    public void run7(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建HQL查询接口
        Query query = session.createQuery("select lkm_name,lkm_gender from Linkman");


        //调用list()方法,查询,返回Object[]数组 (就是查询对应javabean的对象)
        List<Object[]> list = query.list();

        //遍历数组返回Object[],数组中存储的是javabean对象中的数据
        for (Object[] objs : list){
            System.out.println(Arrays.toString(objs));
        }

        tr.commit();
    }
    /**
     * 按条件进行查询
     */
    @Test
    public void run6(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建HQL查询接口
        Query query = session.createQuery("from Linkman l where l.lkm_id> ? and l.lkm_gender = ?");

        //传入
        //query.setString("gender","女");
        //query.setString(0,"女");

        //通用的方法就不用判断具体类型
        query.setParameter(0,3L);
        query.setParameter(1,"女");

        //调用list()方法,查询
        List<Linkman> list = query.list();

        for (Linkman linkman : list){
            System.out.println(linkman);
        }


        tr.commit();
    }
    /**
     * HQL分页查询的两个方法
     *  setFirstResult(a)   从哪条记录开始,如果查询是从第一条开启,值是0
     *  setMaxResults(b)    每页查询的记录条数
     *  相当于 limit a,b;
     */
    @Test
    public void run5(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建HQL查询接口
        Query query = session.createQuery("from Linkman l");

        //分页查询,调用方法
        query.setFirstResult(0);
        query.setMaxResults(3);

        //调用list()方法,查询
        List<Linkman> list = query.list();

        for (Linkman linkman : list){
            System.out.println(linkman);
        }


        tr.commit();
    }

    /**
     * 排序查询
     * SQL:order by 字段 asc/desc(对结果集排序升序降序);
     * HQL:关键字一样的,都使用 order by属性
     *
     */
    @Test
    public void run4(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //查询联系人
        List<Linkman> list = session.createQuery("from Linkman l order by l.lkm_id desc").list();
        for (Linkman linkman : list){
            System.out.println(linkman);
        }

        tr.commit();
    }

    /**
     * 是有别名的方式
     * select c from cst_customer c
     * select * from cst_customer 语句错误的 不能出现*
     */
    @Test
    public void run3(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建HQL查询接口
        Query query = session.createQuery("select c from Customer c");
        //调用list()方法,查询
        List<Customer> list = query.list();

        for (Customer customer : list){
            System.out.println(customer);
        }


        tr.commit();
    }

    /**
     * 支持方法链的编程风格
     */
    @Test
    public void run2(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建HQL查询接口
        List<Customer> list = session.createQuery("from Customer").list();

        for (Customer customer : list){
            System.out.println(customer);
        }

        tr.commit();
    }

    /**
     * 基本演示
     */
    @Test
    public void run1(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        //创建HQL查询接口
        Query query = session.createQuery("from Customer");
        //调用list()方法,查询
        List<Customer> list = query.list();

        for (Customer customer : list){
            System.out.println(customer);
        }

        tr.commit();
    }
}
