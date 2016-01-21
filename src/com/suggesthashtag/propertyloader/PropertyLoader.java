/**
 * 
 */
package com.suggesthashtag.propertyloader;

import java.util.ArrayList;
import java.util.List;

import com.suggesthashtag.propertyloader.datatype.AbstractDataType;
import com.suggesthashtag.propertyloader.datatype.BasicBooleanType;
import com.suggesthashtag.propertyloader.datatype.BasicDoubleType;
import com.suggesthashtag.propertyloader.datatype.BasicFloatType;
import com.suggesthashtag.propertyloader.datatype.BasicIntegerType;
import com.suggesthashtag.propertyloader.datatype.BasicStringType;
import com.suggesthashtag.propertyloader.datatype.DataTypeEnum;
import com.suggesthashtag.propertyloader.decorateProp.PropertyValueDecoratorThread;
import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author sumitpoddar
 */
public class PropertyLoader {

	private Property property = null;

	public void load(PropertyLoaderDetails propFileDetails) {
		ArrayList<PropertyLoaderDetails> list = new ArrayList<PropertyLoaderDetails>();
		list.add(propFileDetails);
		load(list);
	}

	public void load(List<PropertyLoaderDetails> propFileDetailList) {
		property = new Property();
		ArrayList<PropertyValueDecoratorThread> threadList = new ArrayList<PropertyValueDecoratorThread>();
		try {
			
			
			
			for (int index = 0; index < propFileDetailList.size(); index++) {
				//System.out.println("Init " + index);
				PropertyValueDecoratorThread propLoaderDecThread = new PropertyValueDecoratorThread(
						index, propFileDetailList.get(index), "PropLoader_"
								+ index);
				//System.out.println("Adding into Lists");
				//propLoaderDecThread.getThisThread().start();
				threadList.add(propLoaderDecThread);
			}
			for (PropertyValueDecoratorThread thread : threadList) {
				//System.out.println("Starting");
				
				thread.getThisThread().join();
			}
			for (PropertyValueDecoratorThread thread : threadList) {
				//System.out.println(" Putting all --------");
				property.putAll(thread.getTempProperty());
				//System.out.println(property);
			}

		} catch (InterruptedException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
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

	/*
	 * public List getList(String propertyKey) throws PropertyException { if
	 * (this.property.get(propertyKey) == null) {
	 * 
	 * }
	 * 
	 * @SuppressWarnings("unchecked") AbstractDataType<List> basicStringType =
	 * factoryDataTypeMethod(DataTypeEnum.LIST); return
	 * basicStringType.getValue(this.property.getProperty(propertyKey,
	 * defaultValue)); }
	 */
}
