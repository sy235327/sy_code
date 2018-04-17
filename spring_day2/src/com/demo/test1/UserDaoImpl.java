package com.demo.test1;

import org.springframework.stereotype.Repository;

/**
 * UserDaoImpl交给IOC的容器管理
 * @Repository(value="userDao")
 */
@Repository(value="ud")
public class UserDaoImpl implements UserDao{
    @Override
    public void save() {
        System.out.println("保存客户");
    }
}
