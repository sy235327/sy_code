package net.xinqushi.dao;

import org.hibernate.Session;

import net.xinqushi.common.HibernateUtil;
import net.xinqushi.model.User;

public class UserDAO {
	public void save(User user) {
		Session session=HibernateUtil.openSession();
			session.beginTransaction();
			session.merge(user);
			session.getTransaction().commit();
			session.close();
	}
}
