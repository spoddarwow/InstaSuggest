/**
 * 
 */
package com.suggesthashtag.propertyloader.decorateProp;

/**
 * @author sumitpoddar
 *
 */
public class PropertyListHolder {

	private Class listTypeClass;
	private String values;

	/**
	 * @param listTypeClass
	 * @param values
	 */
	public PropertyListHolder(Class listTypeClass, String listValues) {
		super();
	}

	public Class getListTypeClass() {
		return this.listTypeClass;
	}

	public void setListTypeClass(Class listTypeClass) {
		this.listTypeClass = listTypeClass;
	}

	public String getValues() {
		return this.values;
	}

	public void setValues(String values) {
		this.values = values;
	}

}
