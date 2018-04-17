package com.demo.dao;

import com.demo.domain.Linkman;
import com.demo.utils.HibernateUtils;
import org.hibernate.Session;

public class LinkmanDao {
    /**
     * 保存联系人
     * @param man
     */
    public void save(Linkman man) {
        Session session = HibernateUtils.getCurrentSession();
        session.save(man);
    }
}
