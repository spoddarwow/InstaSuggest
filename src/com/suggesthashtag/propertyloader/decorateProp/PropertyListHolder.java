/**
 * 
 */
package com.suggesthashtag.propertyloader.decorateProp;

import com.suggesthashtag.propertyloader.datatype.DataTypeEnum;

/**
 * @author sumitpoddar
 *
 */
public class PropertyListHolder {

	private DataTypeEnum listTypeClass;
	private String values;

	/**
	 * @param listTypeClass
	 * @param values
	 */
	public PropertyListHolder(DataTypeEnum listTypeClass, String listValues) {
		super();
		this.listTypeClass = listTypeClass;
		this.values = listValues;
	}

	public DataTypeEnum getListTypeClass() {
		return this.listTypeClass;
	}

	public void setListTypeClass(DataTypeEnum listTypeClass) {
		this.listTypeClass = listTypeClass;
	}

	public String getValues() {
		return this.values;
	}

	public void setValues(String values) {
		this.values = values;
	}

}
