package com.demo.dao.impl;

import com.demo.dao.CustomerDao;
import com.demo.entity.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerDaoImplTest {

    @org.junit.Test
    public void findById() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        CustomerDao dao = (CustomerDao) context.getBean("customerDao");
        Customer c = dao.findById(23L);
        System.out.println(c);
    }
}