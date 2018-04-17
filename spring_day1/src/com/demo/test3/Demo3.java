package com.demo.test3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo3 {
    /**
     * 测试使用构造方法注入
     */
    @Test
    public void run1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Car1 car1 = (Car1) ac.getBean("car1");
        System.out.println(car1);
    }

    /**
     * 测试构造方法注入对象
     */
    @Test
    public void run2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) ac.getBean("person");
        System.out.println(person);
    }

    @Test
    public void run3(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Car2 car2 = (Car2) ac.getBean("car2");
        System.out.println(car2);
    }

    /**
     * 测试注入集合
     */
    @Test
    public void run4(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) ac.getBean("user");
        System.out.println(user);
    }
}
