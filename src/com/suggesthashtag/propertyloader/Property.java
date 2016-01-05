/**
 * 
 */
package com.suggesthashtag.propertyloader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
		return extractNFormatPropertyValue(propertyKey,
				super.getProperty(propertyKey));
	}

	@Override
	public String getProperty(String propertyKey, String defaultPropValue) {
		return extractNFormatPropertyValue(propertyKey,
				super.getProperty(propertyKey, defaultPropValue));
	}

	private String extractNFormatPropertyValue(String propertyKey,
			String propValue) {
		if (propValue != null && propValue.contains("${")) {
			propValue = PropertyFormatUtil.getInstance().formatPropertyValue(
					propValue, this);
			super.setProperty(propertyKey, propValue);
		}
		return propValue;
	}

	public Object setProperty(String key, String value) {
		return value;

	}
}
