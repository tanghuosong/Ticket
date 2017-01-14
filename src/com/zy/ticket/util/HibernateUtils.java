package com.zy.ticket.util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	private static SessionFactory   sessionFactory=null;
	
	private HibernateUtils(){
	
	}
	static{
		Configuration  configuration=new Configuration().configure();
		sessionFactory=configuration.buildSessionFactory();
	}
	
	public static Session getSession(){
		if(sessionFactory==null){
			Configuration configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
		}
		Session session = sessionFactory.openSession();
		return session;
	}
}
