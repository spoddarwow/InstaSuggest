/**
 * 
 */
package com.suggesthashtag.instaapi;

import java.io.IOException;

import org.apache.commons.configuration2.CombinedConfiguration;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.combined.CombinedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.convert.DefaultListDelimiterHandler;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.log4j.Logger;

import com.suggesthashtag.logger.LoggerLevel;

/**
 * @author sumitpoddar
 *
 */
public class Demo {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Parameters params = new Parameters();
		CombinedConfigurationBuilder builder = new CombinedConfigurationBuilder()
				.configure(
						params.properties()
								.setFileName("mediaPopular.properties")
								.setListDelimiterHandler(
										new DefaultListDelimiterHandler(',')))
				.configure(
						params.properties()
								.setFileName("demo.properties")
								.setListDelimiterHandler(
										new DefaultListDelimiterHandler(',')));

		/*
		 * FileBasedConfigurationBuilder<FileBasedConfiguration> builder = new
		 * FileBasedConfigurationBuilder<FileBasedConfiguration>(
		 * PropertiesConfiguration.class).configure( params.properties()
		 * .setFileName("mediaPopular.properties") .setListDelimiterHandler( new
		 * DefaultListDelimiterHandler(','))) .configure( params.properties()
		 * .setFileName("demo.properties") .setListDelimiterHandler( new
		 * DefaultListDelimiterHandler(',')));
		 */
		try {
			CombinedConfiguration config = builder.getConfiguration();
			System.out.println(config.getString("proxy.type"));
			String[] array = config.getStringArray("db.class_load_1");
			System.out.println(config.getString("newurl"));
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
