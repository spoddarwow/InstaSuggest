/**
 * 
 */
package com.suggesthashtag.db.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.suggesthashtag.db.hibernate.domain.Student;
import com.suggesthashtag.instaapi.framework.SHTMainApp;

/**
 * @author sumitpoddar
 *
 */
public class DBConnectionInit {

	private static DBConnectionInit MY_INSTANCE = null;
	private static SessionFactory factory = null;

	private DBConnectionInit() {

	}

	public static DBConnectionInit getInstance() {
		if (MY_INSTANCE == null) {
			init();
		}
		return MY_INSTANCE;
	}

	/**
	 * @param property
	 */
	private static void init() {
		factory = new Configuration()
				.mergeProperties(SHTMainApp.getPropertyLoader().getProperty())
				.addPackage("com.suggesthashtag.db.hibernate.domain")
				.addAnnotatedClass(Student.class).buildSessionFactory();
	}

	public static SessionFactory getFactory() {
		return factory;
	}

}
