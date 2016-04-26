/**
 * 
 */
package com.suggesthashtag.propertyloader;

import java.util.Properties;

import com.suggesthashtag.propertyloader.datatype.DataTypeEnum;
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
		propertyValue = new PropertyDecoratorValueHandler().decorateProperty(
				propertyValue, properties);
		return propertyValue;
	}

	public PropertyListHolder formatPropertyValueForListType(
			String propertyValue, Properties properties)
			throws PropertyException {
		return new PropertyDecoratorListHandler().decorateProperty(
				propertyValue, properties);
	}

	public Object formatPropertyValues(String propertyValue,
			Properties properties, DataTypeEnum dataTypes)
			throws PropertyException {
		PropertyDecoratorInterface decorator = null;
		switch (dataTypes) {
		case LIST:
			decorator = new PropertyDecoratorListHandler();
			break;
		default:
			decorator = new PropertyDecoratorValueHandler();
			break;
		}
		return decorator.decorateProperty(propertyValue, properties);

	}
}
