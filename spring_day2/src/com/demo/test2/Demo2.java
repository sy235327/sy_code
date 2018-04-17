package com.demo.test2;

import com.demo.test1.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * spring框架整合junit包
 */
//这个注解可以进行运行测试
@RunWith(SpringJUnit4ClassRunner.class)
//通过这个注解可以加载指定目录下的配置文件就是applicationContext.xml文件,扫描注解实例化对象和注入,通过此方式以后测试不需要写工厂
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo2 {
    @Resource(name="userService")
    private UserService userService;

    @Test
    public void run1(){
        //原来:获取工厂,加载配置文件,getBean()
        userService.sayHell();
    }
}
