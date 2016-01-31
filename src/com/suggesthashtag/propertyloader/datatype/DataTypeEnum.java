/**
 * 
 */
package com.suggesthashtag.propertyloader.datatype;

import java.util.List;

import com.suggesthashtag.propertyloader.listPropertyLoader.IntegerListPropertyLoader;
import com.suggesthashtag.propertyloader.listPropertyLoader.ListPropertyLoaderInterface;

/**
 * @author sumitpoddar
 *
 */
public enum DataTypeEnum {

	INTEGER(Integer.class, new IntegerListPropertyLoader()), DOUBLE(
			Double.class, new IntegerListPropertyLoader()), BOOLEAN(
			Boolean.class, new IntegerListPropertyLoader()), STRING(
			String.class, new IntegerListPropertyLoader()), FLOAT(Float.class,
			new IntegerListPropertyLoader()), LIST(List.class, null);

	private Class dataTypeClass;
	private ListPropertyLoaderInterface listPropertyLoader;

	/**
	 * @param dataTypeClass
	 * @param listPropertyLoader
	 */
	private DataTypeEnum(Class dataTypeClass,
			ListPropertyLoaderInterface listPropertyLoader) {
		this.dataTypeClass = dataTypeClass;
		this.listPropertyLoader = listPropertyLoader;
	}

	public Class getDataTypeClass() {
		return this.dataTypeClass;
	}

	public void setDataTypeClass(Class dataTypeClass) {
		this.dataTypeClass = dataTypeClass;
	}

	public ListPropertyLoaderInterface getListPropertyLoader() {
		return this.listPropertyLoader;
	}

	public void setListPropertyLoader(
			ListPropertyLoaderInterface listPropertyLoader) {
		this.listPropertyLoader = listPropertyLoader;
	}

}
