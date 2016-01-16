/**
 * 
 */
package com.suggesthashtag.instaapi;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.http.HttpHost;
import org.apache.log4j.Logger;

import com.suggesthashtag.instaapi.httpconnection.httpProxy.HttpProxyType;
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
		
		try {
		    System.out.println("Holla");
		    System.setOut(new PrintStream(new File("/Volumes/Seagate Expansion Drive/Sumit/My Work/logs/suggesthashTag/sysout.log")));
		    System.out.println("Bye bye. It was fun!!!");
		} catch (Exception e) {
		     e.printStackTrace();
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
