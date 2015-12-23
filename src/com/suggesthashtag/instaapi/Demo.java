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

import com.suggesthashtag.propertyloader.PropertyLoader;
import com.suggesthashtag.propertyloader.PropertyLoaderDetails;
import com.suggesthashtag.propertyloader.exception.PropertyException;

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
		PropertyLoaderDetails propDetails = new PropertyLoaderDetails(
				"demo.properties", null);
		PropertyLoader loader = new PropertyLoader();
		loader.load(propDetails);
		try {
			loader.getString("alpha");
			loader.getInteger("url");
			loader.getString("newurl");
			loader.getString("url");
		} catch (PropertyException exception) {
			// TODO Auto-generated catch block
			System.out.println("Hello");
			exception.printStackTrace();
		}
	}
}
