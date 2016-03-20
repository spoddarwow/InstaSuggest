/**
 * 
 */
package com.suggesthashtag.db.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.suggesthashtag.db.exception.DBException;
import com.suggesthashtag.propertyloader.PropertyLoader;
import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author sumitpoddar
 *
 */
public final class DBConnectionInit {

	private static DBConnectionInit MY_INSTANCE = null;
	private static SessionFactory factory = null;

	private DBConnectionInit() {

	}

	public static DBConnectionInit getInstance(PropertyLoader propertyLoader)
			throws DBException, PropertyException, ClassNotFoundException {
		if (MY_INSTANCE == null) {
			init(propertyLoader);
		}
		return MY_INSTANCE;
	}

	/**
	 * @param property
	 * @throws DBException
	 * @throws PropertyException
	 * @throws ClassNotFoundException
	 */
	private static void init(PropertyLoader propertyLoader) throws DBException,
			PropertyException, ClassNotFoundException {
		Configuration conf = new Configuration();
		if (propertyLoader == null) {
			throw new DBException(
					"Init of DB Factory failed as property is null.");
		} else {
			conf.mergeProperties(propertyLoader.getProperty());
			List<String> packageList = propertyLoader.getList("db.package_add");
			if (packageList != null && !packageList.isEmpty()) {
				for (String packageName : packageList) {
					conf.addPackage(packageName);
				}
			}

			List<String> classToLoadList = propertyLoader
					.getList("db.class_load");
			if (classToLoadList != null && !classToLoadList.isEmpty()) {
				for (String classes : classToLoadList) {
					conf.addAnnotatedClass(Class.forName(classes));
				}
			}
			factory = conf.buildSessionFactory();
		}
	}

	private void closeFactory() {
		this.factory.close();
	}

	private Session openDBSesssionFromFactory() {
		return factory.openSession();
	}

	public Session getOpenSesssion() {
		return openDBSesssionFromFactory();
	}
}
