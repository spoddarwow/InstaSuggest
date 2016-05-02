/**
 * 
 */
package com.suggesthashtag.propertyloader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.suggesthashtag.propertyloader.datatype.DataTypeEnum;
import com.suggesthashtag.propertyloader.datatype.PropertyObjects;
import com.suggesthashtag.propertyloader.decorateProp.PropertyObjectHolder;
import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author sumitpoddar
 *
 */
public class Property extends Properties {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static HashMap<String, List> listHolders = new HashMap<String, List>();
	public static HashMap<String, Object> objectHolders = new HashMap<String, Object>();

	// private static Map<String hash, V>

	@Override
	public void load(InputStream inputStream) throws IOException {
		super.load(inputStream);
	}

	@Override
	public String getProperty(String propertyKey) {
		return super.getProperty(propertyKey);
	}

	@Override
	public String getProperty(String propertyKey, String defaultPropValue) {
		return super.getProperty(propertyKey, defaultPropValue);
	}

	public void put(String key, Object value) {
		if (value instanceof List) {
			listHolders.put(key, (List) value);
			super.remove(key);
		} else if (value instanceof PropertyObjects) {
			objectHolders.put(key, value);
			super.remove(key);
		} else {
			super.put(key, value);
		}
	}

	public String extractNFormatPropertyValue(String propertyKey)
			throws PropertyException {
		String propValue = getProperty(propertyKey);
		if (propValue != null) {
			propValue = (String) PropertyFormatUtil.getInstance()
					.formatPropertyValues(propValue, this, DataTypeEnum.STRING);
		}
		return propValue;
	}

	public String extractNFormatPropertyValue(String propertyKey,
			String defPropValue) throws PropertyException {
		String propValue = getProperty(propertyKey);
		if (propValue != null && propValue.contains("${")) {
			propValue = (String) PropertyFormatUtil.getInstance()
					.formatPropertyValues(propValue, this, DataTypeEnum.STRING);
			super.setProperty(propertyKey, propValue);
		}
		return propValue;
	}

	public static HashMap<String, List> getListHolders() {
		return listHolders;
	}

	public static void setListHolders(HashMap<String, List> listHolders) {
		Property.listHolders = listHolders;
	}

	public static HashMap<String, Object> getObjectHolders() {
		return objectHolders;
	}

	public static void setObjectHolders(HashMap<String, Object> objectHolders) {
		Property.objectHolders = objectHolders;
	}

	public Properties getMainProperty() {
		return this.defaults;
	}

}
