/**
 * 
 */
package com.suggesthashtag.instaapi;

import java.io.File;
import java.io.IOException;

import org.apache.commons.configuration2.CombinedConfiguration;
import org.apache.commons.configuration2.builder.combined.CombinedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.log4j.Logger;

import com.suggesthashtag.db.hibernate.DBConnectionInit;
import com.suggesthashtag.logger.LoggerLevel;

/**
 * @author sumitpoddar
 *
 */
public class Demo {

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException,
			ClassNotFoundException {

		ClassLoader classLoader = DBConnectionInit.class.getClassLoader();
		classLoader
				.loadClass("SHTMediaPopularAPITracker");
		Class clazz = Class
				.forName("com.suggesthashtag.db.hibernate.domain.SHTMediaPopularAPITracker");
		Parameters params = new Parameters();
		CombinedConfigurationBuilder builder = new CombinedConfigurationBuilder()
				.configure(params.fileBased().setFile(new File("config.xml")));
		try {
			CombinedConfiguration config = builder.getConfiguration();
			System.out.println(config.getString("proxy.type"));
			String[] array = config.getStringArray("db.class_load");
			System.out.println(config.getString("newurl"));

			System.out.println(config.getString("db.class_load_1"));
			for (String value : array) {
				System.out.println(value);
			}

		} catch (ConfigurationException cex) {
			// loading of the configuration file failed
		}
	}
}

class DemoThread implements Runnable {

	public Thread thread = null;
	private String threadName = "";

	/**
	 * 
	 */
	public DemoThread(String threadName) {
		super();
		this.threadName = threadName;
		this.thread = new Thread(this, threadName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

		Logger log = Logger.getLogger(Demo.class);
		System.out.println("-=-=-=-=-=-=");
		System.out.println(threadName + " : " + "From Sysout!!!");
		log.error(threadName + " : " + "From Log Error!!!");
		log.debug(threadName + " : " + "Hello Log Debug!!!");
		log.warn(LoggerLevel.INFO);
	}

}
