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
		} else {
			super.put(key, value);
		}
	}

	public String extractNFormatPropertyValue(String propertyKey)
			throws PropertyException {
		String propValue = getProperty(propertyKey);
		if (propValue != null) {
			propValue = PropertyFormatUtil.getInstance().formatPropertyValue(
					propValue, this);
		}
		return propValue;
	}

	public String extractNFormatPropertyValue(String propertyKey,
			String defPropValue) throws PropertyException {
		String propValue = getProperty(propertyKey);
		if (propValue != null && propValue.contains("${")) {
			propValue = PropertyFormatUtil.getInstance().formatPropertyValue(
					propValue, this);
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

}
