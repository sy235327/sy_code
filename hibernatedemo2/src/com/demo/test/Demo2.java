package com.demo.test;

import com.demo.domain.User;
import com.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

/**
 * hibernate高并发跟新数据丢乐观锁解决方案
 */
public class Demo2 {

    @Test
    public void function1(){
        //获取session 开启事务
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        //获取持久化对象
        User user = session.get(User.class, 1);

        //操作缓存
        user.setName("隔壁老王");


        //提交事务，session缓存进行了提交，数据更新
        session.beginTransaction().commit();

        //关闭资源
        session.close();
    }

    @Test
    public void function2(){
        //获取session 开启事务
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        //获取持久化对象
        User user = session.get(User.class, 1);

        //操作缓存
        user.setAge(10);

        //提交事务，session缓存进行了提交，数据更新
        session.beginTransaction().commit();

        //关闭资源
        session.close();
    }
}
