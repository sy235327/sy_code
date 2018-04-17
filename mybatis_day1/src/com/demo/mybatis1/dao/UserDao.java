package com.demo.mybatis1.dao;

import com.demo.mybatis1.entity.User;

/**
 * 用户dao
 */
public interface UserDao {
    User findUserById(Integer id);
}
