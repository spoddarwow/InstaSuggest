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
		boolean dynamicPropValOn = false;
		if (properties == null) {
			// TODO: Throw exception to load property first.
		}
		String propertyValueToRet = propertyValue;
		StringBuffer formattedPropertyValue = new StringBuffer();
		if (propertyValue != null && !"".equals(propertyValue)
				&& propertyValue.contains("${")) {
			char[] propertyValueChars = propertyValue.toCharArray();
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

		return propertyValueToRet;

	}
}
