/**
 * 
 */
package com.suggesthashtag.propertyloader.datatype;

import java.util.List;

import com.suggesthashtag.propertyloader.listPropertyLoader.IntegerListPropertyLoader;
import com.suggesthashtag.propertyloader.listPropertyLoader.ListPropertyLoaderInterface;
import com.suggesthashtag.propertyloader.listPropertyLoader.StringListPropertyLoader;

/**
 * @author sumitpoddar
 *
 */
public enum DataTypeEnum {

	INTEGER(Integer.class, new IntegerListPropertyLoader(),
			new BasicIntegerType()), DOUBLE(Double.class,
			new IntegerListPropertyLoader(), new BasicDoubleType()), BOOLEAN(
			Boolean.class, new IntegerListPropertyLoader(),
			new BasicBooleanType()), STRING(String.class,
			new StringListPropertyLoader(), new BasicStringType()), FLOAT(
			Float.class, new IntegerListPropertyLoader(), new BasicFloatType()), LIST(
			List.class, null, null), OBJECT(Object.class, null, null);

	private Class dataTypeClass;
	private ListPropertyLoaderInterface listPropertyLoader;
	private AbstractDataType parserDataTypeClass;

	/**
	 * @param dataTypeClass
	 * @param listPropertyLoader
	 */
	private DataTypeEnum(Class dataTypeClass,
			ListPropertyLoaderInterface listPropertyLoader,
			AbstractDataType parserDataTypeClass) {
		this.dataTypeClass = dataTypeClass;
		this.listPropertyLoader = listPropertyLoader;
		this.parserDataTypeClass = parserDataTypeClass;
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

	public AbstractDataType getParserDataTypeClass() {
		return this.parserDataTypeClass;
	}

	public void setParserDataTypeClass(AbstractDataType parserDataTypeClass) {
		this.parserDataTypeClass = parserDataTypeClass;
	}

}
