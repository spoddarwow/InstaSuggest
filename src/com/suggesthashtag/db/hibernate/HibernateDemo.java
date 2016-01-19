/**
 * 
 */
package com.suggesthashtag.db.hibernate;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.suggesthashtag.db.hibernate.domain.Student;

/**
 * @author xspro
 *
 */
public class HibernateDemo {

	private static SessionFactory factory = null;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties property = new Properties();
		InputStream inputStream = HibernateDemo.class
				.getClassLoader()
				.getResourceAsStream(
						"demo.properties");
		property.load(inputStream);
		try {
			factory = new AnnotationConfiguration().configure()
					.setProperties(property)
					.addPackage("com.suggesthashtag.db.hibernate.domain")
					.addAnnotatedClass(Student.class).buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		System.out.println(factory);
	}

}
