package dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

import common.HibernateUtil;
import model.Student;

public class StudentDAO {
	Session session;
	public void add(Student student) {
		session=HibernateUtil.openSession();
	Transaction ts=	session.beginTransaction();
	session.save(student);
	ts.commit();
	session.close();
	}
}
