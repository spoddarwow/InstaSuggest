/**
 * 
 */
package com.suggesthashtag.propertyloader.decorateProp;

import com.suggesthashtag.propertyloader.datatype.DataTypeEnum;

/**
 * @author sumitpoddar
 *
 */
public class PropertyListHolder extends PropertyOtherAttributeHolder {

	private DataTypeEnum listTypeClass;

	/**
	 * @param listTypeClass
	 * @param values
	 */
	public PropertyListHolder(DataTypeEnum listTypeClass, String listValues) {
		super();
		this.listTypeClass = listTypeClass;
		super.values = listValues;
	}

	public DataTypeEnum getListTypeClass() {
		return this.listTypeClass;
	}

	public void setListTypeClass(DataTypeEnum listTypeClass) {
		this.listTypeClass = listTypeClass;
	}

}
