package com.demo.dao;

import com.demo.domain.User;
import com.demo.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

/**
 *
 */
public class UserDao {
    /**
     * 注册用户
     * @param user
     * @return
     */
    public int register(User user) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?);";
        int update = qr.update(sql,user.getUid(),user.getUsername(),user.getPassword(),
                user.getName(),user.getEmail(),user.getTelephone(),
                user.getBirthdar(),user.getSex(),user.getState(),user.getCode());
        return update;
    }

    /**
     * 用户激活
     * @param activeCode 激活码
     * @return 修改结果
     */
    public int active(String activeCode) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update user set state=? where code=?";
        int update = qr.update(sql, 1, activeCode);
        return update;
    }

    /**
     * 校验用户名是否存在
     * @param username 用户名
     * @return 查询结果
     */
    public Long checkUsernaem(String username) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from user where username=?";
        Long i = (Long) qr.query(sql, new ScalarHandler(), username);
        return i;
    }

    /**
     * 用户登陆
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public User login(String username, String password) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where username=? and password=? and state = 1";
        return qr.query(sql,new BeanHandler<User>(User.class),username,password);
    }
}
