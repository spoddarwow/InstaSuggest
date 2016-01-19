/**
 * 
 */
package com.suggesthashtag.db.hibernate.domain;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
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
		System.out.println(property);
		try {
			
			factory = new AnnotationConfiguration()
					.configure(new File("C:\\Sumit\\Git_Repo_Luna\\230814\\SuggestHashTag\\config\\demo.properties"))
					//.addPackage("com.suggesthashtag.db.hibernate.domain")
					//.addAnnotatedClass(Student.class)
					.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		System.out.println(factory);
	}

}
