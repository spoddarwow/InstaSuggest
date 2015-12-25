/**
 * 
 */
package com.suggesthashtag.instaapi;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.suggesthashtag.logger.LogManager;
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
		LogManager.getInstance().log("Hello simple.");
		LogManager.getInstance().log(LoggerLevel.WARN, "Hello with level.");
		DemoThread thread = null;
		//thread.run();
		try {
			thread.run();
		} catch (NullPointerException exception) {
			LogManager.getInstance().log(LoggerLevel.ERROR,
					"Error Thrown : " + exception.getLocalizedMessage());
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
