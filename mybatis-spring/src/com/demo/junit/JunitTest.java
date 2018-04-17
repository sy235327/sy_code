package com.demo.junit;

import com.demo.entity.User;
import com.demo.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JunitTest {

    /**
     * 动态mapper代理开发
     */
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapper = (UserMapper) applicationContext.getBean("userMapper");
        User user = mapper.selectUserById(1);
        System.out.println(user);
    }

    /**
     * 动态mapper代理开发增强
     */
    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapper = applicationContext.getBean(UserMapper.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);
    }

    @Test
    public void run()   {
        int n = 1;
        int x = 0;
        while(n<=15){
            x=x+n;
            n=n+2;
        }
        System.out.println(x);
    }
}
