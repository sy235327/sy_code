package com.demo.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * 原始开发
 * spring框架提供了一个SqlSessionDaoSupport类,dao直接继承这个类在配置中直接注入SqlSessionFactory工厂即可
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    public void insertUser(){
//        this.getSqlSession().insert("",);

    }
}
