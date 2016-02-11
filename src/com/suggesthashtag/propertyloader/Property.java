/**
 * 
 */
package com.suggesthashtag.propertyloader;

import java.io.IOException;
import java.io.InputStream;
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

}
