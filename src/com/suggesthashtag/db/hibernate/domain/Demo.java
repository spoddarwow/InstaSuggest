/**
 * 
 */
package com.suggesthashtag.db.hibernate.domain;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author xspro
 *
 */
public class Demo {

	private static SessionFactory factory = null;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties property = new Properties();
		InputStream inputStream = Demo.class.getClassLoader()
				.getResourceAsStream("demo.properties");
		property.load(inputStream);
		try {
			factory = new Configuration().mergeProperties(property)
					// .configure("hibernate.cfg.xml")
					.addPackage("com.suggesthashtag.db.hibernate.domain")
					//.addAnnotatedClass(Student.class)
					.buildSessionFactory();
			Session session = factory.getCurrentSession();
			Student student = new Student(100045, "Sumit Poddar", 19);
			try {

				session.beginTransaction();
				session.save(student);
				session.getTransaction().commit();
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		} finally {
			factory.close();
		}
		System.out.println(factory);
	}

}
