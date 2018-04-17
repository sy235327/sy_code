package com.demo.test1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo1 {
    /**
     * 原来的方式
     */
    @Test
    public void run1(){
        UserService service = new UserServiceImpl();
        service.sayHell();
    }

    /**
     * 测试spring注解配置
     */
    @Test
    public void run2(){
        //获取工厂,加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserServiceImpl) ac.getBean("userService");
        userService.sayHell();
    }
}
