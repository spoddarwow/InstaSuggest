/**
 * 
 */
package com.suggesthashtag.propertyloader.propertyDecorator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.suggesthashtag.propertyloader.Property;
import com.suggesthashtag.propertyloader.PropertyLoaderDetails;

/**
 * @author sumitpoddar
 *
 */
public class PropertyDecoratorObject {

	private List<PropertyLoaderDetails> propertyLoaderList = new ArrayList<PropertyLoaderDetails>();
	private HashMap<String, Properties> processingPropertiesMap = new HashMap<String, Properties>();
	private Property finalProperty = new Property();

	/**
	 * @param propertyLoaderList
	 * @param processingPropertiesMap
	 * @param finalProperty
	 */
	public PropertyDecoratorObject(
			List<PropertyLoaderDetails> propertyLoaderList,
			HashMap<String, Properties> processingPropertiesMap,
			Property finalProperty) {
		super();
		this.propertyLoaderList = propertyLoaderList;
		this.processingPropertiesMap = processingPropertiesMap;
		this.finalProperty = finalProperty;
	}

	public List<PropertyLoaderDetails> getPropertyLoaderList() {
		return this.propertyLoaderList;
	}

	public void setPropertyLoaderList(
			List<PropertyLoaderDetails> propertyLoaderList) {
		this.propertyLoaderList = propertyLoaderList;
	}

	public HashMap<String, Properties> getProcessingPropertiesMap() {
		return this.processingPropertiesMap;
	}

	public void setProcessingPropertiesMap(
			HashMap<String, Properties> processingPropertiesMap) {
		this.processingPropertiesMap = processingPropertiesMap;
	}

	public Property getFinalProperty() {
		return this.finalProperty;
	}

	public void setFinalProperty(Property finalProperty) {
		this.finalProperty = finalProperty;
	}

}
