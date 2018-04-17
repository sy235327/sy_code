package com.demo.test1;

/**
 * spring框架aop-动态代理
 * 被代理对象
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("保存客户");
    }

    @Override
    public void update() {
        System.out.println("修改客户");
    }
}
