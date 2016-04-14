/**
 * 
 */
package com.suggesthashtag.db.hibernate;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.hibernate.SessionFactory;

import com.suggesthashtag.propertyloader.PropertyLoader;
import com.suggesthashtag.propertyloader.PropertyLoaderDetails;
import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author xspro
 *
 */
public class HibernateDemo {

	private static SessionFactory factory = null;

	/**
	 * @param args
	 * @throws IOException
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws PropertyException
	 */
	public static void main(String[] args) throws IOException,
			PropertyException, InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		PropertyLoader property = new PropertyLoader();

		property.load(new PropertyLoaderDetails("demo.properties"));
		try {
			factory = DBConnectionInit.getInstance(property).getFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		System.out.println(factory);
	}

}
