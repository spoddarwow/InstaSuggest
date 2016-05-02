/**
 * 
 */
package com.suggesthashtag.propertyloader.decorateProp;

import java.util.HashMap;

import com.suggesthashtag.propertyloader.Property;

/**
 * @author sumitpoddar
 *
 */
public class PropertyLoaderObject {

	private Property tempProperty = new Property();
	private int index;
	private HashMap<String, PropertyListHolder> listHolderMap = new HashMap<String, PropertyListHolder>();
	private HashMap<String, PropertyObjectHolder> propertyObjectHolderMap = new HashMap<String, PropertyObjectHolder>();

	/**
	 * 
	 */
	public PropertyLoaderObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Property getTempProperty() {
		return this.tempProperty;
	}

	public void setTempProperty(Property tempProperty) {
		this.tempProperty = tempProperty;
	}

	public int getIndex() {
		return this.index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public HashMap<String, PropertyListHolder> getListHolderMap() {
		return this.listHolderMap;
	}

	public void setListHolderMap(
			HashMap<String, PropertyListHolder> listHolderMap) {
		this.listHolderMap = listHolderMap;
	}

	public HashMap<String, PropertyObjectHolder> getPropertyObjectHolderMap() {
		return this.propertyObjectHolderMap;
	}

	public void setPropertyObjectHolderMap(
			HashMap<String, PropertyObjectHolder> propertyObjectHolderMap) {
		this.propertyObjectHolderMap = propertyObjectHolderMap;
	}

	public void put(String key, Object object) {
		if (object instanceof PropertyListHolder) {
			this.listHolderMap.put(key, (PropertyListHolder) object);
		} else if (object instanceof PropertyObjectHolder) {
			this.propertyObjectHolderMap
					.put(key, (PropertyObjectHolder) object);
		}
	}
}
