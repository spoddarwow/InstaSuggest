/**
 * 
 */
package com.suggesthashtag.propertyloader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.suggesthashtag.propertyloader.datatype.AbstractDataType;
import com.suggesthashtag.propertyloader.datatype.BasicBooleanType;
import com.suggesthashtag.propertyloader.datatype.BasicDoubleType;
import com.suggesthashtag.propertyloader.datatype.BasicFloatType;
import com.suggesthashtag.propertyloader.datatype.BasicIntegerType;
import com.suggesthashtag.propertyloader.datatype.BasicStringType;
import com.suggesthashtag.propertyloader.datatype.DataTypeEnum;
import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author sumitpoddar
 */
public class PropertyLoader {

	private Property property = null;

	public void load(PropertyLoaderDetails propFileDetails)
			throws PropertyException {
		ArrayList<PropertyLoaderDetails> list = new ArrayList<PropertyLoaderDetails>();
		list.add(propFileDetails);
		load(list);
	}

	public void load(List<PropertyLoaderDetails> propFileDetailList)
			throws PropertyException {
		property = new Property();
		try {
			for (PropertyLoaderDetails propFileDetails : propFileDetailList) {
				InputStream inputStream = PropertyLoader.class.getClassLoader()
						.getResourceAsStream(propFileDetails.toString());
				if (inputStream != null) {
					Property tempProperty = new Property();
					tempProperty.load(inputStream);
					this.property.putAll(tempProperty);
				} else {
					throw new FileNotFoundException("Property file "
							+ propFileDetails.toString()
							+ " not found in the classpath");
				}
			}
		} catch (FileNotFoundException exception) {
			throw new PropertyException(exception);
		} catch (IOException exception) {
			throw new PropertyException(exception);
		}
	}

	public Property getProperty() {
		return this.property;
	}

	private AbstractDataType factoryDataTypeMethod(DataTypeEnum dataType) {
		AbstractDataType abstractDataType = null;
		switch (dataType) {
		case INTEGER:
			abstractDataType = new BasicIntegerType();
			break;
		case DOUBLE:
			abstractDataType = new BasicDoubleType();
			break;
		case FLOAT:
			abstractDataType = new BasicFloatType();
			break;
		case BOOLEAN:
			abstractDataType = new BasicBooleanType();
		default:
			abstractDataType = new BasicStringType();
			break;
		}
		return abstractDataType;
	}

	public int getInteger(String propertyKey) throws PropertyException,
			NumberFormatException {
		@SuppressWarnings("unchecked")
		AbstractDataType<Integer> basicIntType = factoryDataTypeMethod(DataTypeEnum.INTEGER);
		return basicIntType.getValue(this.property.getProperty(propertyKey));
	}

	public int getInteger(String propertyKey, String defaultValue)
			throws PropertyException {
		@SuppressWarnings("unchecked")
		AbstractDataType<Integer> basicIntType = factoryDataTypeMethod(DataTypeEnum.INTEGER);
		return basicIntType.getValue(this.property.getProperty(propertyKey,
				defaultValue));
	}

	public double getDouble(String propertyKey) throws PropertyException {
		@SuppressWarnings("unchecked")
		AbstractDataType<Double> basicDoubleType = factoryDataTypeMethod(DataTypeEnum.DOUBLE);
		return basicDoubleType.getValue(this.property.getProperty(propertyKey));
	}

	public double getDouble(String propertyKey, String defaultValue)
			throws PropertyException {
		@SuppressWarnings("unchecked")
		AbstractDataType<Double> basicDoubleType = factoryDataTypeMethod(DataTypeEnum.DOUBLE);
		return basicDoubleType.getValue(this.property.getProperty(propertyKey,
				defaultValue));
	}

	public float getFloat(String propertyKey) throws PropertyException {
		@SuppressWarnings("unchecked")
		AbstractDataType<Float> basicFloatType = factoryDataTypeMethod(DataTypeEnum.FLOAT);
		return basicFloatType.getValue(this.property.getProperty(propertyKey));
	}

	public float getFloat(String propertyKey, String defaultValue)
			throws PropertyException {
		@SuppressWarnings("unchecked")
		AbstractDataType<Float> basicFloatType = factoryDataTypeMethod(DataTypeEnum.FLOAT);
		return basicFloatType.getValue(this.property.getProperty(propertyKey,
				defaultValue));
	}

	public boolean getBoolean(String propertyKey) throws PropertyException {
		@SuppressWarnings("unchecked")
		AbstractDataType<Boolean> basicBooleanType = factoryDataTypeMethod(DataTypeEnum.BOOLEAN);
		return basicBooleanType
				.getValue(this.property.getProperty(propertyKey));
	}

	public boolean basicBooleanType(String propertyKey, String defaultValue)
			throws PropertyException {
		@SuppressWarnings("unchecked")
		AbstractDataType<Boolean> basicBooleanType = factoryDataTypeMethod(DataTypeEnum.BOOLEAN);
		return basicBooleanType.getValue(this.property.getProperty(propertyKey,
				defaultValue));
	}

	public String getString(String propertyKey) throws PropertyException {
		@SuppressWarnings("unchecked")
		AbstractDataType<String> basicStringType = factoryDataTypeMethod(DataTypeEnum.STRING);
		return basicStringType.getValue(this.property.getProperty(propertyKey));
	}

	public String getString(String propertyKey, String defaultValue)
			throws PropertyException {
		@SuppressWarnings("unchecked")
		AbstractDataType<String> basicStringType = factoryDataTypeMethod(DataTypeEnum.STRING);
		return basicStringType.getValue(this.property.getProperty(propertyKey,
				defaultValue));
	}

	public List getList(String propertyKey) throws PropertyException {
		if (this.property.get(propertyKey) == null) {

		}
		@SuppressWarnings("unchecked")
		AbstractDataType<List> basicStringType = factoryDataTypeMethod(DataTypeEnum.LIST);
		return basicStringType.getValue(this.property.getProperty(propertyKey,
				defaultValue));
	}
}
