/**
 * 
 */
package com.suggesthashtag.propertyloader.decorateProp;

import java.util.ArrayList;
import java.util.List;
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
	public <T> T decorateProperty(String value) throws PropertyException {
		Object returningObject = null;
		Class listType = null;
		String listValues = "";
		if (value != null && !"".equals(value)) {
			Pattern pattern = Pattern.compile("List<([a-zA-Z]+)>\\[(.*)\\]$");
			Matcher matcher = pattern.matcher(value);
			if (matcher.matches()) {
				String classValue = matcher.group(1);
				DataTypeEnum listDataType = DataTypeEnum.valueOf(classValue);
				if (listDataType != null
						&& listDataType.getListPropertyLoader() != null
						&& listDataType.getListPropertyLoader().isEligible()) {
					pattern = Pattern.compile(listDataType
							.getListPropertyLoader().getPattern());
					matcher = pattern.matcher(value);
					if (matcher.matches()) {
						listValues = matcher.group(1);
						if (listValues.endsWith(",")) {
							listValues = listValues.substring(0,
									listValues.length());
						}
						listType = listDataType.getDataTypeClass();
					}
				}
			}
			if (listType != null && listValues != null && !"".equals(listType)) {
				returningObject = new PropertyListHolder(listType, listValues);
			} else {
				throw new PropertyException("List is not defined properly: "
						+ value);
			}

		} else {
			returningObject = value;
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

	private List<String> getPatternList() {
		List<String> patternList = new ArrayList<String>();
		patternList.add("List<");
		patternList.add("?");
		patternList.add(">[");
		patternList.add("?");
		patternList.add("]");
		return patternList;
	}

}
