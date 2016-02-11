/**
 * 
 */
package com.suggesthashtag.propertyloader.decorateProp;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.suggesthashtag.propertyloader.datatype.DataTypeEnum;
import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author sumitpoddar
 *
 */
public class PropertyDecoratorListHandler implements PropertyDecoratorInterface {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.suggesthashtag.propertyloader.decorateProp.PropertyDecoratorInterface
	 * #decorateProperty(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T decorateProperty(String value, Properties properties)
			throws PropertyException {
		Object returningObject = null;
		String listValues = "";
		DataTypeEnum listDataType = null;
		if (value != null && !"".equals(value)) {
			Pattern pattern = Pattern.compile("List<([a-zA-Z]+)>\\[(.*)\\]$",
					Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(value);
			if (matcher.matches()) {
				String classValue = matcher.group(1);
				listDataType = DataTypeEnum.valueOf(classValue.toUpperCase());
				if (listDataType != null
						&& listDataType.getListPropertyLoader() != null
						&& listDataType.getListPropertyLoader().isEligible()) {
					pattern = Pattern.compile(listDataType
							.getListPropertyLoader().getPattern(),
							Pattern.CASE_INSENSITIVE);
					matcher = pattern.matcher(value);
					if (matcher.matches()) {
						listValues = matcher.group(2);
						if (listValues.endsWith(",")) {
							listValues = listValues.substring(0,
									listValues.length());
						}
					}
				}
			}
			if (listDataType != null && listValues != null) {
				returningObject = new PropertyListHolder(listDataType,
						listValues);
			} else {
				throw new PropertyException("List is not defined properly: "
						+ value);
			}

		}
		return (T) returningObject;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.suggesthashtag.propertyloader.decorateProp.PropertyDecoratorInterface
	 * #isCriteriaMetForThisDecorator(java.lang.String)
	 */
	@Override
	public boolean isCriteriaMetForThisDecorator(String value) {
		return value.trim().toLowerCase().startsWith("List<")
				&& value.contains(">[") && value.trim().endsWith("]");
	}

}
