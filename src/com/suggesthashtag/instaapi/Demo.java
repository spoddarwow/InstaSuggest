/**
 * 
 */
package com.suggesthashtag.instaapi;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.suggesthashtag.instaapi.response.bean.MediaPopularResponse;
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
		String authResponse = "";
		Gson gson = new Gson();
		MediaPopularResponse root = gson.fromJson(new FileReader(new File("/Volumes/Seagate Expansion Drive/Sumit/My Work/Git/SuggestHashTag/src/com/suggesthashtag/instaapi/mediapopular/sampleResponse")),
				MediaPopularResponse.class);
		System.out.println(root);
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
