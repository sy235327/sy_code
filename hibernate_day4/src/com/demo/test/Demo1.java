package com.demo.test;

import com.demo.domain.Customer;
import com.demo.domain.Linkman;
import com.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * 对象导航的方式查询多表方(对象导航方式只能用在一对多和多对多中)
 */
public class Demo1 {

    /**
     * 通过客户查询客户下面的联系人
     */
    @Test
    public void run1(){
        //先查询1号客户
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //显示有OID的方式查询客户
        Customer customer = session.get(Customer.class, 1L);

        System.out.println("====================");

        //查看该客户下的联系人的集合
        System.out.println(customer.getLinkmans().size());

        tr.commit();

    }

    /**
     * 通过客户查询属于哪个联系人
     */
    @Test
    public void run2(){
        //先查询1号客户
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();

        //先查询联系人
        Linkman linkman = session.get(Linkman.class, 5L);
        System.out.println("====================");

        System.out.println(linkman.getCustomer().getCust_name());

        tr.commit();

    }
}
