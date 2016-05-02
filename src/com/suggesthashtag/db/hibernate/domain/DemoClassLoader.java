/**
 * 
 */
package com.suggesthashtag.db.hibernate.domain;


/**
 * @author sumitpoddar
 *
 */
public class DemoClassLoader {

	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader classLoader = DemoClassLoader.class.getClassLoader();
		classLoader.loadClass("SHTMediaPopularAPITracker");
	}
}
