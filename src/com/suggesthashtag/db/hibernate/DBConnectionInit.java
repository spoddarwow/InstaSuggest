/**
 * 
 */
package com.suggesthashtag.db.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.suggesthashtag.db.exception.DBException;
import com.suggesthashtag.instaapi.framework.SHTMainApp;
import com.suggesthashtag.propertyloader.PropertyLoader;
import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author sumitpoddar
 *
 */
public final class DBConnectionInit {

	private static SessionFactory factory = null;

	/**
	 * @param property
	 * @throws DBException
	 * @throws PropertyException
	 * @throws ClassNotFoundException
	 */
	public static void init() throws DBException, PropertyException,
			ClassNotFoundException {
		if (factory == null) {
			PropertyLoader propertyLoader = SHTMainApp.getPropertyLoader();
			Configuration conf = new Configuration();
			if (propertyLoader == null) {
				throw new DBException(
						"Init of DB Factory failed as property is null.");
			} else {
				conf.mergeProperties(propertyLoader.getProperty());
				List<String> packageList = propertyLoader
						.getList("db.package_add");
				if (packageList != null && !packageList.isEmpty()) {
					for (String packageName : packageList) {
						conf.addPackage(packageName);
					}
				}

				ClassLoader classLoader = DBConnectionInit.class
						.getClassLoader();
				List<String> classToLoadList = propertyLoader
						.getList("db.class_load");
				if (classToLoadList != null && !classToLoadList.isEmpty()) {
					for (String classes : classToLoadList) {
						conf.addAnnotatedClass(classLoader
								.loadClass(propertyLoader.getString(classes)));
					}
				}
				factory = conf.buildSessionFactory();
			}
		}
	}

	public static void closeFactory() {
		factory.close();
	}

	private static Session openDBSesssionFromFactory() {
		return factory.openSession();
	}

	public static Session getOpenSesssion() {
		return openDBSesssionFromFactory();
	}
}
