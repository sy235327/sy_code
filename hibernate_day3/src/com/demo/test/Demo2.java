package com.demo.test;

import com.demo.domain.Role;
import com.demo.domain.User;
import com.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Set;

/**
 * 多对多的测试
 */
public class Demo2 {

    /**
     * 多对多需要操作对象修改数据,必须有一方放弃(一般都是那个表用的少那方放弃)
     */
    @Test
    public void run1(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //模拟多对多,双向的关联
        User u1 =  new User();
        u1.setUsername("张三");
        User u2 = new User();
        u2.setUsername("王五");

        Role r1 = new Role();
        r1.setRname("经理");
        Role r2 = new Role();
        r2.setRname("学生");

        //关联
        u1.getRoles().add(r1);
        r1.getUsers().add(u1);
        u1.getRoles().add(r2);
        r2.getUsers().add(u1);


        r1.getUsers().add(u2);
        u2.getRoles().add(r1);

        session.save(u1);
        session.save(u2);
        session.save(r1);
        session.save(r2);

        tr.commit();
    }

    /**
     * 多对多级联保存
     */
    @Test
    public void run2(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //多对多,级联关联
        //创建用户
        User u1 = new User();
        u1.setUsername("张三");
        User u2 = new User();
        u2.setUsername("李四");

        //创建角色
        Role r1 = new Role();
        r1.setRname("经理");
        Role r2 = new Role();
        r2.setRname("服务员");

        u1.getRoles().add(r1);
        u1.getRoles().add(r2);
        u2.getRoles().add(r2);

        //保存数据
        session.save(u1);
        session.save(u2);

        tr.commit();
    }

    /**
     * 张三用户,有两个角色,经理和服务员
     * 现在将张三去掉一个角色 只做经理
     * 删除中间表张三对应服务员的数据
     */
    @Test
    public void run3(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //查询张三用户
        User u1 = session.get(User.class,1L);

        //查询角色
        Role r1 = session.get(Role.class, 2L);

        //操作集合 就相当于操作中间表
        u1.getRoles().remove(r1);

        tr.commit();
    }
}
