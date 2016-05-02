/**
 * 
 */
package com.suggesthashtag.propertyloader.decorateProp;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.suggesthashtag.propertyloader.datatype.PropertyObjects;
import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author sumitpoddar
 *
 */
public class PropertyFormatterObjectHandler implements
		PropertyFormatterInterface {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.suggesthashtag.propertyloader.decorateProp.PropertyFormatterInterface
	 * #formatPropertyValue(java.lang.String, java.util.Properties)
	 */
	@Override
	public <T> T formatPropertyValue(String value, Properties properties)
			throws PropertyException {
		Object returningObject = null;
		String jsonValues = null;
		StringBuffer jsonValueStrBuffer = new StringBuffer();
		Class<? extends PropertyObjects> jsonObjectDataType = null;
		String classValue = "";
		if (value != null && !"".equals(value)) {
			// Get type of list.
			Pattern pattern = Pattern.compile(
					"Object<([a-zA-Z]+)>\\[\\{(.*)\\}\\]$",
					Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(value);
			if (matcher.matches()) {
				classValue = matcher.group(1);
				String jsonStrValue = matcher.group(2);
				if (((classValue != null) && (!"".equals(classValue)))
						&& ((jsonStrValue != null) && (!"".equals(jsonStrValue)))) {

					jsonValueStrBuffer.append("{").append(jsonStrValue.trim())
							.append("}");
					jsonValues = jsonValueStrBuffer.toString();
				}

			}
			if (classValue != null && !"".equals(classValue)
					&& jsonValues != null && !"".equals(jsonValues)) {
				returningObject = new PropertyObjectHolder(classValue,
						jsonValueStrBuffer.toString());
			} else {
				throw new PropertyException("Object is not defined properly: "
						+ value);
			}

		}
		return (T) returningObject;

	}
}
