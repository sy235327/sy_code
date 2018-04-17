package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateutil {
	  static Configuration configuration=null;
	  static SessionFactory sessionFactory=null;
	
	
	static {
	configuration=new Configuration().configure();
    sessionFactory = configuration.buildSessionFactory();
		
		
	}
	public static SessionFactory getsessionfactory() {
		return sessionFactory;
		
		
		
	}
	public static void main(String[] args) {
		Session session = getsessionfactory().openSession();
		System.out.println(session);
	}

}
