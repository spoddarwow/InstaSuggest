/**
 * 
 */
package com.suggesthashtag.instaapi.mediapopular;

/**
 * @author xspro
 *
 */
public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Heelo");
		SHTMediaPopularRequestHandler handler = new SHTMediaPopularRequestHandler(
				"Demo");
		String[] env = { "environment", "ACPT" };
		handler.main(env);
	}

}
