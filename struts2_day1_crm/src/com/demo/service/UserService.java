package com.demo.service;

import com.demo.dao.UserDao;
import com.demo.domain.User;
import com.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * 用户的业务层
 */
public class UserService {

    /**
     * 处理登陆功能
     * @param user 接收到的用户信息
     * @return 查询到的用户信息
     */
    public User login(User user){
        //开启事务
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        User userQuery = null;
        try{
            //调用持久层,查询数据
            userQuery = new UserDao().findByNameAndPwd(user);
            tr.commit();
        }catch(Exception e){
            tr.rollback();
        }
        return userQuery;
    }

    @Test
    public void run(){
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        User userQuery = this.login(user);
        if (userQuery!=null)
            System.out.println();
    }
}
