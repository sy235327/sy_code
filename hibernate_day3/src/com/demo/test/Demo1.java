package com.demo.test;

import com.demo.domain.Customer;
import com.demo.domain.Linkman;
import com.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Scanner;


/**
 * 测试一对多
 */
public class Demo1 {

    /**
     * 让一方放弃维护,让多方使用对象维护(因为一方维护当数据过大时集合内部存储过大,两方都维护会导致sql执行语句过多无用)
     */
    @Test
    public void run10(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //获取主表中的数据 客户
        Customer customer = session.get(Customer.class, 2L);
        //获取外表中的数据 联系人
        Linkman linkman = session.get(Linkman.class,2L);

        //将联系人和客户关联
        customer.getLinkmans().add(linkman);
        linkman.setCustomer(customer);

        //提交事务
        tr.commit();
    }
    /**
     * 解除关系:从集合中删除联系人(需要使用孤儿删除需要去主表的映射文件中的set标签中cascade属性配置delete-orphan)
     */
    @Test
    public void run9(){
        //获取session,开启事务
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //先获取到客户
        Customer customer = session.get(Customer.class,1L);

        //拿到联系人
        Linkman linkman = session.get(Linkman.class, 2L);

        //解除
        customer.getLinkmans().remove(linkman);

        //提交事务
        tr.commit();
    }


    /**
     * 级联删除,删除联系人,同时删除外键对应主表中的数据
     * 在联系人映射文件中的many-to-one标签中的cascade属性值添加delete,(如果主表中也有那么删除联系人或者客户都会全部删除)
     */
    @Test
    public void run8(){
        //获取session,开启事务
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //删除,先查询
        Linkman customer = session.get(Linkman.class,5L);
        session.delete(customer);


        //提交事务
        tr.commit();
    }

    /**
     * 级联删除,删除客户,同时删除从表中的对应客户外键的数据
     * 在客户映射文件中的set标签中的cascade属性值添加delete
     */
    @Test
    public void run7(){
        //获取session,开启事务
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //删除,先查询
        Customer customer = session.get(Customer.class,2L);
        session.delete(customer);


        //提交事务
        tr.commit();
    }


    /**
     * 测试,一对多中的删除
     * 删除客户,客户下面有两个联系人
     * 删除一对多是先修改多方的外键改为null,再删除主表中的数据(设置了外键约束不能直接删除主表中的数据)
     */
    @Test
    public void run6(){
        //获取session,开启事务
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //删除先查询
        Customer customer = session.get(Customer.class,1l);
        session.delete(customer);


        //提交事务
        tr.commit();
    }


    /**
     * 级联保存
     * 单项关联
     * 保存联系人级联是客户
     */
    @Test
    public void run5(){
        //获取session,开启事务
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //保存客户和联系人的数据
        Customer c1 = new Customer();
        c1.setCust_name("赵六");

        //创建2个联系人
        Linkman l1 = new Linkman();
        l1.setLkm_name("laok1");
        Linkman l2 = new Linkman();
        l2.setLkm_name("laok2");

        //单向关联
        //客户关联联系人
        l1.setCustomer(c1);

         c1.getLinkmans().add(l2);

        //保存数据
        session.save(l1);

        //提交事务
        tr.commit();
    }

    /**
     * 级联保存
     * 保存联系人级联是客户
     */
    @Test
    public void run4(){
        //获取session,开启事务
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //保存客户和联系人的数据
        Customer c1 = new Customer();
        c1.setCust_name("赵六");

        //创建2个联系人
        Linkman l1 = new Linkman();
        l1.setLkm_name("laok1");
        Linkman l2 = new Linkman();
        l2.setLkm_name("laok2");

        //单向关联
        //客户关联联系人
        l1.setCustomer(c1);
        l2.setCustomer(c1);

        //保存数据
        session.save(l1);
        session.save(l2);

        //提交事务
        tr.commit();
    }

    /**
     * 级联保存
     * 保存客户级联是联系人
     */
    @Test
    public void run3(){
        //获取session,开启事务
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //保存客户和联系人的数据
        Customer c1 = new Customer();
        c1.setCust_name("赵六");

        //创建2个联系人
        Linkman l1 = new Linkman();
        l1.setLkm_name("laok1");
        Linkman l2 = new Linkman();
        l2.setLkm_name("laok2");

        //单向关联
        //客户关联联系人
        c1.getLinkmans().add(l1);
        c1.getLinkmans().add(l2);

        //保存数据
        session.save(c1);

        //提交事务
        tr.commit();
    }

    /**
     * 单向关联的方式,保存数据,需要配置级联保存
     */
    @Test
    public void run2(){
        //获取session,开启事务
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //保存客户和联系人的数据
        Customer c1 = new Customer();
        c1.setCust_name("赵六");

        //创建2个联系人
        Linkman l1 = new Linkman();
        l1.setLkm_name("laok1");
        Linkman l2 = new Linkman();
        l2.setLkm_name("laok2");

        //单向关联
        //客户关联联系人
        c1.getLinkmans().add(l1);
        c1.getLinkmans().add(l2);

        //保存数据
        session.save(c1);

        //提交事务
        tr.commit();
    }


    /**
     * 双向关联的方式,保存数据
     */
    @Test
    public void run1(){
        //获取session,开启事务
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //保存客户和联系人的数据
        Customer c1 = new Customer();
        c1.setCust_name("赵六");

        //创建2个联系人
        Linkman l1 = new Linkman();
        l1.setLkm_name("laok1");
        Linkman l2 = new Linkman();
        l2.setLkm_name("laok2");

        //双向关联
        //客户关联联系人
        c1.getLinkmans().add(l1);
        c1.getLinkmans().add(l2);
        //联系人关联客户
        l1.setCustomer(c1);
        l2.setCustomer(c1);

        //保存数据
        session.save(c1);
        session.save(l1);
        session.save(l2);

        //提交事务
        tr.commit();
    }

    @Test
    public void run11(){
            int i,sum=0,x,max=0;

            int min = 0;//最小值

            Scanner sc=new Scanner(System.in);
            System.out.println("输入3个数值：");

            for(i=1;i<=3;i++){

                x=sc.nextInt();

                if(x>max)
                {
                    max=x;
                }

                if(x<=min){
                    min=x;

                }

                sum+=x;

            }
            System.out.println("和为："+sum);
            System.out.println("平均值为："+sum/10.0);
            System.out.println("最大值为："+max);
            System.out.println("最小值为："+min);

    }
}
