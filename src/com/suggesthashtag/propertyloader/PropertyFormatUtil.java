/**
 * 
 */
package com.suggesthashtag.propertyloader;

import java.util.Properties;

import com.suggesthashtag.propertyloader.datatype.DataTypeEnum;
import com.suggesthashtag.propertyloader.decorateProp.PropertyFormatterInterface;
import com.suggesthashtag.propertyloader.decorateProp.PropertyFormatterListHandler;
import com.suggesthashtag.propertyloader.decorateProp.PropertyFormatterObjectHandler;
import com.suggesthashtag.propertyloader.decorateProp.PropertyFormatterValueHandler;
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

	/*
	 * public String formatPropertyValue(String propertyValue, Properties
	 * properties) throws PropertyException { propertyValue = new
	 * PropertyDecoratorValueHandler() .formatPropertyValue(propertyValue,
	 * properties); return propertyValue; }
	 * 
	 * public PropertyListHolder formatPropertyValueForListType( String
	 * propertyValue, Properties properties) throws PropertyException { return
	 * new PropertyDecoratorListHandler().formatPropertyValue( propertyValue,
	 * properties); }
	 */

	public Object formatPropertyValues(String propertyValue,
			Properties properties, DataTypeEnum dataTypes)
			throws PropertyException {
		PropertyFormatterInterface decorator = null;
		switch (dataTypes) {
		case LIST:
			decorator = new PropertyFormatterListHandler();
			break;
		case OBJECT:
			decorator = new PropertyFormatterObjectHandler();
			break;
		default:
			decorator = new PropertyFormatterValueHandler();
			break;
		}
		return decorator.formatPropertyValue(propertyValue, properties);

	}
}
