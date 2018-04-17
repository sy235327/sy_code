package com.demo.text1;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * 测试IOC的程序
 */
public class Demo1 {

    /**
     * 原来的方式
     */
    @Test
    public void run1(){
        //创建实现类
        UserServiceImpl service = new UserServiceImpl();
//        UserService service = new UserServiceImpl();
        service.setName("大桥未久");
        service.sayHello();
    }

    /**
     * 使用Spring框架的方式
     */
    @Test
    public void run2(){
        //创建工厂,加载核心的配置,加载完毕后配置文件中的对象直接创建完毕,单例对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        //从工厂中获取到对象
        UserServiceImpl  Service =(UserServiceImpl) ac.getBean("userService");

        //调用对象的方法执行
        Service.sayHello();
    }

    /**
     * 使用Spring框架
     * 接口的方式,方便扩展
     */
    @Test
    public void run3(){
        //创建工厂,加载核心的配置,加载完毕后配置文件中的对象直接创建完毕,单例对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        //从工厂中获取到对象
        UserService  Service =(UserService) ac.getBean("userService");

        //调用对象的方法执行
        Service.sayHello();
    }

    /**
     * 老工厂的版本 BeanFactory
     * 在调用getBean方法才会创建对象
     */
    @Test
    public void run4(){
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        UserService service = (UserService)factory.getBean("userService");
        service.sayHello();
    }

    /**
     * 演示销毁的方法
     */
    @Test
    public void run5(){
        //创建工厂,加载核心的配置,加载完毕后配置文件中的对象直接创建完毕,单例对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        //从工厂中获取到对象
        UserService  service = (UserService) ac.getBean("userService");

        //调用对象的方法执行
        service.sayHello();

        //关闭工厂,工厂关闭了,对象都会销毁
        ac.close();
    }

    /**
     * DI 依赖注入概念
     */
    @Test
    public void run6(){
        //创建工厂,加载核心的配置,加载完毕后配置文件中的对象直接创建完毕,单例对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        //从工厂中获取到对象
        UserService  service = (UserService) ac.getBean("userService");

        //调用对象的方法执行
        service.sayHello();
    }
}
