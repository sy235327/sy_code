package com.demo.dao;

import com.demo.domain.User;
import com.demo.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * 持久层
 */
public class UserDao {

    /**
     * 通过用户名和密码查询数据库
     * @User user 接收到用户信息
     * @return
     */
    public User findByNameAndPwd(User user){
        //先获取
        Session session = HibernateUtils.getCurrentSession();
        //使用用户名和密码查询
        Query query = session.createQuery("from User where username=? and password=?");
        //设置参数
        query.setParameter(0,user.getUsername());
        query.setParameter(1,user.getPassword());
        //查询
        List<User> list = query.list();
        //判断
        if (list != null && list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
