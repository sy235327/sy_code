package com.demo.test;

import com.demo.domain.Person;
import com.demo.domain.User;
import com.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.io.Serializable;

/**
 * 向数据表添加数据
 */
public class Demo1 {

    @Test
    public void run1(){
        //获取session
        Session session = HibernateUtils.getSession();

        //开启事务
        Transaction tr = session.beginTransaction();

        //操作对象
        User user = new User();
        user.setName("王五");
        user.setAge(19);

        //保存数据
        session.save(user);

        //提交事务
        tr.commit();

        //关闭资源
        HibernateUtils.close(session);


    }

    /**
     * 测试uuid主键的生产策略
     */
    @Test
    public void run2(){
        //获取session
        Session session = HibernateUtils.getSession();

        //开启事务
        Transaction tr = session.beginTransaction();

        //操作对象
        Person person = new Person();
        person.setPid("aaa");
        person.setPname("王五");

        //保存数据
        session.save(person);

        //提交事务
        tr.commit();

        //关闭资源
        session.close();
    }


    /**
     * 演示持久类的对象的三个状态
     */
    @Test
    public void run3(){
        //获取session 开启事务
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        //持久User的对象
        //瞬时态： 没有OID的值，没有session管理，此时user对象是瞬时态对象
        User user= new User();
        user.setName("小泽老师");
        user.setAge(18);

        //保存数据
        // 持久化： user对象中已经存在id的值(框架管理的主键)，默认的情况下，把user对象也保存到session的缓存中
        Serializable id = session.save(user);
        System.out.println("主键的值"+id);

        //提交事务
        session.beginTransaction().commit();

        //关闭资源，session销毁，缓存没有了
        session.close();

        //打印
        //托管态：user对象存在id值，session销毁了，缓存不存在了，session不管理user对象
        System.out.println(user.getId());
        System.out.println(user.getName());
    }

    /**
     * 持久化对象有自动更新数据库的能力
     * session对象的一级缓存
     */
    @Test
    public void run4(){
        //获取session 开启事务
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        //查询数据 直接获取一个持久化对象
        User user = session.get(User.class, 1);
        System.out.println("打印user name= "+user.getName());

        //修改对象中的数据
        user.setName("小苍老师");

        //提交事务
        session.beginTransaction().commit();
        //关闭资源
        session.close();
    }

    /**
     * 测试session的一级缓存
     */
    @Test
    public void run5(){
        //获取session 开启事务
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        //创建对象
        User user = new User();
        user.setName("哈哈");
        user.setAge(1);
        //保存数据 user数据存储到session缓存中
        Serializable id = session.save(user);

        //查询数据,由于在session缓存中存储了id这个字段的数据，就读取缓存中的数据返回
        User user1 = session.get(User.class, id);
        System.out.println(user1.getName());

        //提交事务，session缓存进行了提交，数据更新
        session.beginTransaction().commit();

        //关闭资源
        session.close();
    }
}
