package com.demo.dao;

import com.demo.domain.User;
import com.demo.utils.HibernateUtils;
import org.hibernate.Session;

/**
 * Created by Administrator on 2018/3/14.
 */
public class UserDao {
    public void save1(User u) {
        Session currentSession = HibernateUtils.getCurrentSession();
        currentSession.save(u);

    }

    public void save2 (User u){
        Session currentSession = HibernateUtils.getCurrentSession();
        currentSession.save(u);
    }
}
