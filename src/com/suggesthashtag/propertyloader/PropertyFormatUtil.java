/**
 * 
 */
package com.suggesthashtag.propertyloader;

import java.util.Properties;

/**
 * @author sumitpoddar
 *
 */
public class PropertyFormatUtil {

	private static PropertyFormatUtil MY_INSTANCE = new PropertyFormatUtil();

	private PropertyFormatUtil() {

	}

	public static PropertyFormatUtil getInstance() {
		return MY_INSTANCE;
	}

	public String formatPropertyValue(String propertyValue,
			Properties properties) {
		Properties property = PropertyLoader.getProperty();
		if (property == null) {
			// TODO: Throw exception to load property first.
		}

		if (property.contains("${")) {
			Stack
		}

		return propertyValue;

	}
}
