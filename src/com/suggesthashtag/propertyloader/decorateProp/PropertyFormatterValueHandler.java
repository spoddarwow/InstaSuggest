/**
 * 
 */
package com.suggesthashtag.propertyloader.decorateProp;

import java.util.Properties;

import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author sumitpoddar
 *
 */
public class PropertyFormatterValueHandler implements
		PropertyFormatterInterface {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.suggesthashtag.propertyloader.decorateProp.PropertyDecoratorInterface
	 * #decorateProperty(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T formatPropertyValue(String value, Properties properties)
			throws PropertyException {

		boolean dynamicPropValOn = false;
		if (properties == null) {
			// TODO: Throw exception to load property first.
		}
		String propertyValueToRet = value;
		StringBuffer formattedPropertyValue = new StringBuffer();
		if (value != null && !"".equals(value) && value.contains("${")) {
			char[] propertyValueChars = value.toCharArray();
			int charIndex = 0;
			StringBuffer dynamicPropValueKey = new StringBuffer();
			while (charIndex < propertyValueChars.length) {
				if (propertyValueChars[charIndex] == '$'
						&& propertyValueChars[charIndex + 1] == '{') {

					if (dynamicPropValOn) {
						// Throw Exception
					} else {
						dynamicPropValOn = true;
						charIndex++;
					}
				} else if (propertyValueChars[charIndex] == '}') {
					if (dynamicPropValOn) {
						dynamicPropValOn = false;

						if (properties.getProperty(dynamicPropValueKey
								.toString(), System
								.getProperty(dynamicPropValueKey.toString())) != null) {
							formattedPropertyValue.append(formatPropertyValue(
									properties.getProperty(dynamicPropValueKey
											.toString(), System
											.getProperty(dynamicPropValueKey
													.toString())), properties));
						} else {
							formattedPropertyValue.append("${")
									.append(dynamicPropValueKey).append("}");
						}

						dynamicPropValueKey = new StringBuffer();
					} else {
						formattedPropertyValue
								.append(propertyValueChars[charIndex]);
					}

				} else if (dynamicPropValOn) {
					dynamicPropValueKey.append(propertyValueChars[charIndex]);
				} else if (!dynamicPropValOn) {
					formattedPropertyValue
							.append(propertyValueChars[charIndex]);
				}
				charIndex++;
			}
			propertyValueToRet = formattedPropertyValue.toString();
		}

		return (T) propertyValueToRet;

	}

}
