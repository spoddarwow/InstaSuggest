/**
 * 
 */
package com.suggesthashtag.instaapi;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

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
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		// BufferedInputStream inputStream = new BufferedInputStream(new
		// FileInputStream("../config/demo.properties"));
		InputStream inputStream = Demo.class.getClassLoader()
				.getResourceAsStream("demo.properties");
		if (inputStream != null) {
			prop.load(inputStream);
			System.out.println("loaded : " + prop.getProperty("newUrl"));
		} else {
			throw new FileNotFoundException(
					"property file 'demo.prop' not found in the classpath");
		}
	}

}
