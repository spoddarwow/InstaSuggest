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
	private Properties properties = new Properties();

	@Override
	public void load(InputStream inputStream) throws IOException {
		this.properties.load(inputStream);
	}

	@Override
	public String getProperty(String propertyKey) {
		return extractNFormatPropertyValue(propertyKey,
				this.properties.getProperty(propertyKey));
	}

	@Override
	public String getProperty(String propertyKey, String defaultPropValue) {
		return extractNFormatPropertyValue(propertyKey,
				this.properties.getProperty(propertyKey, defaultPropValue));
	}

	private String extractNFormatPropertyValue(String propertyKey,
			String propValue) {
		if (propValue != null && propValue.contains("${")) {
			propValue = PropertyFormatUtil.getInstance().formatPropertyValue(
					propValue, this.properties);
			this.properties.setProperty(propertyKey, propValue);
		}
		return propValue;
	}

	public Properties getProperties() {
		return this.properties;
	}
}
