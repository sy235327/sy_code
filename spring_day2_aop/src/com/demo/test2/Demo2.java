package com.demo.test2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 测试AOP功能
 */
//加载配置 生成实例
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class Demo2 {
    @Resource(name="customerDao")
    private CustomerDao customerDao;

    @Test
    public void run1(){
        customerDao.save();
//        customerDao.update();
    }
}
