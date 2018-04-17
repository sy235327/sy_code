package com.demo.test1;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class Demo1 {

    /**
     * 原来的方式
     */
    @Test
    public void run1(){
        UserDao dao = new UserDaoImpl();
        dao.save();
        dao.update();
    }

    @Test
    public void run2(){
        UserDao dao = new UserDaoImpl();
        //使用工具类,获取到代理对象
        UserDao userDao = MyProxyUtils.getUserDao(dao);
        //调用代理对象的方法
        userDao.save();
        userDao.update();

    }
}
