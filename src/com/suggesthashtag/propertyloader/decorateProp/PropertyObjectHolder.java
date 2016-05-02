/**
 * 
 */
package com.suggesthashtag.propertyloader.decorateProp;


/**
 * @author sumitpoddar
 *
 */
public class PropertyObjectHolder extends PropertyOtherAttributeHolder {

	private String jsonObjectClass = null;

	/**
	 * @param listTypeClass
	 * @param listValues
	 */
	public PropertyObjectHolder(String jsonObjectClass, String listValues) {
		super();
		this.jsonObjectClass = jsonObjectClass;
		super.values = listValues;
	}

	public String getJsonObjectClass() {
		return this.jsonObjectClass;
	}

	public void setJsonObjectClass(String jsonObjectClass) {
		this.jsonObjectClass = jsonObjectClass;
	}

}
