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

}
