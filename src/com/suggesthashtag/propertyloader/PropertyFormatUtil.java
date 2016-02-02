/**
 * 
 */
package com.suggesthashtag.propertyloader;

import java.util.Properties;

import com.suggesthashtag.propertyloader.decorateProp.PropertyDecoratorInterface;
import com.suggesthashtag.propertyloader.decorateProp.PropertyDecoratorListHandler;
import com.suggesthashtag.propertyloader.decorateProp.PropertyDecoratorValueHandler;
import com.suggesthashtag.propertyloader.decorateProp.PropertyListHolder;
import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author sumitpoddar
 * 
 *         TODO: Better design
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
			Properties properties) throws PropertyException {
		PropertyDecoratorInterface deoratorHandler = new PropertyDecoratorValueHandler();
		propertyValue = deoratorHandler.decorateProperty(propertyValue,
				properties);
		return propertyValue;
	}

	public PropertyListHolder formatPropertyValueForListType(
			String propertyValue, Properties properties)
			throws PropertyException {
		PropertyListHolder holder = null;
		PropertyDecoratorInterface deoratorHandler = new PropertyDecoratorListHandler();
		holder = deoratorHandler.decorateProperty(propertyValue, properties);
		return holder;
	}
}
