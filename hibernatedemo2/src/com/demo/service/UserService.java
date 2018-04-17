package com.demo.service;

import com.demo.dao.UserDao;
import com.demo.domain.User;
import com.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 在业务层开启事务
 * 将session绑定在当前线程上
 */
public class UserService {
    public void save(User u1,User u2){
        UserDao dao = new UserDao();
        //获取session
        //开启事务
        Session session = HibernateUtils.getCurrentSession();
        Transaction tr = session.beginTransaction();
        try{
            //操作对象
            dao.save1(u1);
            //int i = 10/0;
            dao.save2(u2);

            //提交事务
            tr.commit();

        }catch(Exception e){
            //回滚事务
            tr.rollback();
        }
        //从线程中获取的session，不需要自己关闭资源了，线程结束，自动关闭
    }
}
