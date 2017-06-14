package utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionfactory {
	public static SessionFactory factory;
	//to disallow creating objects by other classes.
	 
	    private HibernateSessionfactory() {
			// TODO Auto-generated constructor stub
		}
	 
	    public static synchronized SessionFactory getSessionFactory() {
	 
	        if (factory == null) {
	            factory = new Configuration().configure("hibernate.config.xml").
	                    buildSessionFactory();
	        }
	        return factory;
	    }
}
