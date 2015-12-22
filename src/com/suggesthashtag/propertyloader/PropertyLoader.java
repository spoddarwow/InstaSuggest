/**
 * 
 */
package com.suggesthashtag.propertyloader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.suggesthashtag.propertyloader.datatype.AbstractDataType;
import com.suggesthashtag.propertyloader.datatype.BasicBooleanType;
import com.suggesthashtag.propertyloader.datatype.BasicDoubleType;
import com.suggesthashtag.propertyloader.datatype.BasicFloatType;
import com.suggesthashtag.propertyloader.datatype.BasicIntegerType;
import com.suggesthashtag.propertyloader.datatype.DataTypeEnum;

/**
 * @author sumitpoddar
 */
public class PropertyLoader {

	private Properties property = new Properties();

	public void load(PropertyLoaderDetails propFileDetails) {
		load(propFileDetails);
	}

	public void load(PropertyLoaderDetails... propFileDetailList)
			throws IOException {
		for (PropertyLoaderDetails propFileDetails : propFileDetailList) {
			InputStream inputStream = PropertyLoader.class.getClassLoader()
					.getResourceAsStream(propFileDetails.toString());
			if (inputStream != null) {
				property.load(inputStream);
			} else {
				throw new FileNotFoundException(
						"property file 'demo.prop' not found in the classpath");
			}
		}
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
			abstractDataType = new BasicBooleanType();
			break;
		}
		return abstractDataType;
	}

	public int getInteger(String propertyKey) {
		@SuppressWarnings("unchecked")
		AbstractDataType<Integer> basicIntType = factoryDataTypeMethod(DataTypeEnum.INTEGER);
		return basicIntType.getValue(this.property.getProperty(propertyKey));
	}

	public int getInteger(String propertyKey, String defaultValue) {
		@SuppressWarnings("unchecked")
		AbstractDataType<Integer> basicIntType = factoryDataTypeMethod(DataTypeEnum.INTEGER);
		return basicIntType.getValue(this.property.getProperty(propertyKey,
				defaultValue));
	}

	public double getDouble(String propertyKey) {
		@SuppressWarnings("unchecked")
		AbstractDataType<Double> basicDoubleType = factoryDataTypeMethod(DataTypeEnum.DOUBLE);
		return basicDoubleType.getValue(this.property.getProperty(propertyKey));
	}

	public double getDouble(String propertyKey, String defaultValue) {
		@SuppressWarnings("unchecked")
		AbstractDataType<Double> basicDoubleType = factoryDataTypeMethod(DataTypeEnum.DOUBLE);
		return basicDoubleType.getValue(this.property.getProperty(propertyKey,
				defaultValue));
	}

	public float getFloat(String propertyKey) {
		@SuppressWarnings("unchecked")
		AbstractDataType<Float> basicFloatType = factoryDataTypeMethod(DataTypeEnum.FLOAT);
		return basicFloatType.getValue(this.property.getProperty(propertyKey));
	}

	public float getFloat(String propertyKey, String defaultValue) {
		@SuppressWarnings("unchecked")
		AbstractDataType<Float> basicFloatType = factoryDataTypeMethod(DataTypeEnum.FLOAT);
		return basicFloatType.getValue(this.property.getProperty(propertyKey,
				defaultValue));
	}

	public boolean getBoolean(String propertyKey) {
		@SuppressWarnings("unchecked")
		AbstractDataType<Boolean> basicBooleanType = factoryDataTypeMethod(DataTypeEnum.BOOLEAN);
		return basicBooleanType
				.getValue(this.property.getProperty(propertyKey));
	}

	public boolean basicBooleanType(String propertyKey, String defaultValue) {
		@SuppressWarnings("unchecked")
		AbstractDataType<Boolean> basicBooleanType = factoryDataTypeMethod(DataTypeEnum.BOOLEAN);
		return basicBooleanType.getValue(this.property.getProperty(propertyKey,
				defaultValue));
	}

	public String getString(String propertyKey) {
		AbstractDataType<String> basicStringType = factoryDataTypeMethod(DataTypeEnum.STRING);
		return basicStringType.getValue(this.property.getProperty(propertyKey));
	}

	public String getString(String propertyKey, String defaultValue) {
		AbstractDataType<String> basicStringType = factoryDataTypeMethod(DataTypeEnum.STRING);
		return basicStringType.getValue(this.property.getProperty(propertyKey,
				defaultValue));
	}
}