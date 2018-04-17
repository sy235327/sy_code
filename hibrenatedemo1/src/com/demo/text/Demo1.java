package com.demo.text;

import com.demo.domain.Customer;
import com.demo.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;

/**
 * 测试hibernate框架
 */
public class Demo1 {
    /**
     * 测试保存一个客户
     * 使用hibernate步骤
     * 1.加载配置文件
     * 2.创建SessionFactory对象，生成Session对象（不是webSession）
     * 3.创建一个Session对象  数据的会话技术
     * 4.开启事务
     * 5.编写保存的代码
     * 6.提交事务
     * 7.释放资源
     */
    @Test
    public void fun() {
        //1.加载一个配置文件
        Configuration config = new Configuration() {
        };
        //默认加载src目录下的hibernate.cfg.xml的配置文件
        config.configure();

        //2.创建SessionFactory对象
        SessionFactory sessionfactory = config.buildSessionFactory();
        //3.创建一个Session对象
        Session session = sessionfactory.openSession();

        //4.开启事务
        Transaction tr = session.beginTransaction();

        //5.编写保存代码
        Customer c = new Customer();
//        c.setCust_id(cust_id); 主键是自动递增的 hibernate已经帮我们去管理主键了
        c.setCust_name("测试");
        c.setCust_level("2");
        c.setCust_phone("110");

        //保存数据，操作对象就相当于操作数据库的表结构
        session.save(c);

        //6.提交事务
        tr.commit();

        //7.释放资源
        session.close();
        sessionfactory.close();

    }

    /**
     * 测试hibernate框架工具类
     */
    @Test
    public void test2() {
        //1.调用工具类获取一个session对象，与数据库的会话技术
        Session session = HibernateUtils.getSession();

        //2.开启事务
        Transaction action = session.beginTransaction();

        //3.操作对象
        Customer cust = new Customer();
        cust.setCust_name("测试");

        //4.保存
        session.save(cust);

        //5.提交事务
        action.commit();

        //6.关闭资源
        session.close();
    }

    /**
     * 测试get()方法，获取查询，通过主键查询一条记录
     */
    @Test
    public void testGet() {
        //1.调用工具类，获取session对象
        Session session = HibernateUtils.getSession();

        //2.开启事务
        Transaction action = session.beginTransaction();

        //3.测试查询方法,2个参数  arg0：查询javabean的class对象. arg1:主键的值
        Customer customer = session.get(Customer.class, 7L);
        System.out.println("d:" + customer.getCust_name());


        //4.提交事务
        action.commit();


        //5.关闭资源
        session.close();

    }

    /**
     * 测试删除的方法
     * 注意： 删除或者修改，先查询再删除或者修改
     */
    @Test
    public void testDel() {
        //1.从工具类获取session
        Session session = HibernateUtils.getSession();

        //2.开启事务
        Transaction action = session.beginTransaction();

        //3.查询,在删除
        Customer customer = session.get(Customer.class, 7L);
        session.delete(customer);

        //4.提交事物
        action.commit();

        //5.关闭资源
        session.close();
    }

    /**
     * 测试修改
     */
    @Test
    public void testUpdate() {
        //1.从工具类获取session
        Session session = HibernateUtils.getSession();

        //2.开启事务
        Transaction action = session.beginTransaction();

        //3.查询,在修改
        Customer customer = session.get(Customer.class, 7L);
        customer.setCust_name("测试1");
        customer.setCust_level("3");
        session.update(customer);

        //4.提交事物
        action.commit();

        //5.关闭资源
        session.close();
    }

    /**
     * 测试添加或者修改（如果存在则修改，如果不存在者添加）
     */
    @Test
    public void testSaveOrUpdate() {
        //1.从工具类获取session
        Session session = HibernateUtils.getSession();

        //2.开启事务
        Transaction action = session.beginTransaction();

        //3.测试添加或者修改（如果存在则修改，如果不存在者添加）
/*
        Customer customer = new Customer();
//        customer.setCust_id(1L);  框架在维护了 不需要自己设置（会报错）
        customer.setCust_name("测试2");
        //添加或者修改
        session.saveOrUpdate(customer);
*/

        //先查询在改
        Customer customer = session.get(Customer.class, 8L);
        customer.setCust_name("测试3");
        //添加或者修改
        session.saveOrUpdate(customer);


        //4.提交事物
        action.commit();

        //5.关闭资源
        session.close();
    }

    /**
     * 测试查询
     */
    @Test
    public void textSel() {
        //1.从工具类获取session
        Session session = HibernateUtils.getSession();

        //2.开启事务
        Transaction action = session.beginTransaction();

        //3.HQL查询,创建查询的接口
        Query query = session.createQuery("from Customer");
        //查询所有的数据 select * from 表
        List<Customer> list = query.list();
        for (Customer customer : list){
            System.out.println(customer);
        }

        //4.提交事物
        action.commit();

        //5.关闭资源
        session.close();
    }

    /**
     * 测试保存
     */
    @Test
    public void testSave3(){
        Session session = null;
        Transaction action = null;
        try {
            //获取session
            session = HibernateUtils.getSession();

            //开启事务
            action = session.beginTransaction();

            //操作对象
            Customer cust = new Customer();
            cust.setCust_name("哈哈");

            //保存
            session.save(cust);

            //提交事务
            action.commit();
        }catch(Exception e){
            //回滚事务
            action.rollback();
            System.out.println(e);
        }finally{
            //释放资源
            session.close();
        }
    }
}