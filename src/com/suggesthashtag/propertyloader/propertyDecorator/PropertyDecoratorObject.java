/**
 * 
 */
package com.suggesthashtag.propertyloader.propertyDecorator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.suggesthashtag.propertyloader.Property;
import com.suggesthashtag.propertyloader.PropertyLoaderDetails;
import com.suggesthashtag.propertyloader.decorateProp.PropertyLoaderObject;

/**
 * @author sumitpoddar
 *
 */
public class PropertyDecoratorObject {

	private List<PropertyLoaderDetails> propertyLoaderList = new ArrayList<PropertyLoaderDetails>();
	private HashMap<String, PropertyLoaderObject> processingPropertiesMap = new HashMap<String, PropertyLoaderObject>();
	private Property finalProperty = new Property();

	/**
	 * @param propertyLoaderList
	 * @param processingPropertiesMap
	 * @param finalProperty
	 */
	public PropertyDecoratorObject(
			List<PropertyLoaderDetails> propertyLoaderList) {
		super();
		this.propertyLoaderList = propertyLoaderList;
	}

	public List<PropertyLoaderDetails> getPropertyLoaderList() {
		return this.propertyLoaderList;
	}

	public void setPropertyLoaderList(
			List<PropertyLoaderDetails> propertyLoaderList) {
		this.propertyLoaderList = propertyLoaderList;
	}

	public HashMap<String, PropertyLoaderObject> getProcessingPropertiesMap() {
		return this.processingPropertiesMap;
	}

	public void setProcessingPropertiesMap(
			HashMap<String, PropertyLoaderObject> processingPropertiesMap) {
		this.processingPropertiesMap = processingPropertiesMap;
	}

	public Property getFinalProperty() {
		return this.finalProperty;
	}

	public void setFinalProperty(Property finalProperty) {
		this.finalProperty = finalProperty;
	}

}
