/**
 * 
 */
package com.suggesthashtag.propertyloader.datatype;

import java.util.List;

/**
 * @author sumitpoddar
 *
 */
public enum DataTypeEnum {

	INTEGER(Integer.class), DOUBLE(Double.class), BOOLEAN(Boolean.class), STRING(
			String.class), FLOAT(Float.class), LIST(List.class);

	private Class dataTypeClass;

	/**
	 * @param dataTypeClass
	 */
	private DataTypeEnum(Class dataTypeClass) {
		this.dataTypeClass = dataTypeClass;
	}

	public Class getDataTypeClass() {
		return this.dataTypeClass;
	}

	public void setDataTypeClass(Class dataTypeClass) {
		this.dataTypeClass = dataTypeClass;
	}

}
