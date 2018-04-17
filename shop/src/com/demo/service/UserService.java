package com.demo.service;

import com.demo.dao.UserDao;
import com.demo.domain.User;

import java.sql.SQLException;

/**
 * service层
 */
public class UserService {
    /**
     * 注册用户
     * @param user 用户注册信息
     * @return 布尔值
     */
    public boolean register(User user){
        UserDao dao = new UserDao();
        int row = 0;
        try {
            row = dao.register(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row>0? true:false;
    }

    /**
     * 用户激活
     * @param activeCode 激活码
     */
    public boolean active(String activeCode) {
        UserDao dao = new UserDao();
        int active = 0;
        try {
            active = dao.active(activeCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (active == 1){
            return true;
        }
        return false;
    }

    /**
     * 校验用户名是否存在
     * @param username 用户名
     * @return 是否存在 boolean值
     */
    public boolean checkUsername(String username) {
        UserDao dao = new UserDao();
        Long i = 0l;
        try {
            i = dao.checkUsernaem(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i==0? true:false;
    }

    /**
     * 用户登陆
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public boolean login(String username, String password) {
        UserDao dao = new UserDao();
        User user = null;
        try {
            user = dao.login(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user != null){
            return true;
        }
        return false;
    }
}
