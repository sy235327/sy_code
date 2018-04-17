package com.demo.test2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo2 {
    /**
     * 原始方式,依赖直接new
     */
    @Test
    public void run1(){
        CustomerServiceImpl cs = new CustomerServiceImpl();
        cs.save();
    }

    /**
     * Spring方式,DL 依赖注入
     */
    @Test
    public void run2(){
        //创建工厂,加载配置,CustomerServiceImpl被创建了,CustomerDaoImpl创建了,
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerServiceImpl cs = (CustomerServiceImpl) ac.getBean("CustomerService");
        cs.save();
    }
}
