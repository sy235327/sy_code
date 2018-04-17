package com.demo.dao;

import com.demo.domain.Linkman;
import com.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class LinkmanDao {
    /**
     * 保存联系人
     * @param man
     */
    public void save(Linkman man) {
        Session session = HibernateUtils.getCurrentSession();
        session.save(man);
    }

    /**
     * 查询所有的联系人
     * @return 返回联系人集合
     */
    public List<Linkman> findAll() {
        Session session = HibernateUtils.getCurrentSession();
        return session.createQuery("from Linkman").list();
    }

    /**
     * 获取离线条件查询对象,查询数据库
     * @param criteria 离线条件查询对象
     * @return 联系人集合
     */
    public List<Linkman> findAll(DetachedCriteria criteria) {
        //先获取到session
        Session session = HibernateUtils.getCurrentSession();
        //执行
        return criteria.getExecutableCriteria(session).list();
    }
}
