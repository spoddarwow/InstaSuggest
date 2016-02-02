/**
 * 
 */
package com.suggesthashtag.propertyloader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.suggesthashtag.propertyloader.datatype.AbstractDataType;
import com.suggesthashtag.propertyloader.datatype.BasicBooleanType;
import com.suggesthashtag.propertyloader.datatype.BasicDoubleType;
import com.suggesthashtag.propertyloader.datatype.BasicFloatType;
import com.suggesthashtag.propertyloader.datatype.BasicIntegerType;
import com.suggesthashtag.propertyloader.datatype.BasicStringType;
import com.suggesthashtag.propertyloader.datatype.DataTypeEnum;
import com.suggesthashtag.propertyloader.decorateProp.PropertyListHolder;
import com.suggesthashtag.propertyloader.decorateProp.PropertyLoaderObject;
import com.suggesthashtag.propertyloader.decorateProp.PropertyValueDecoratorThread;
import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author sumitpoddar
 */
public final class PropertyLoader {

	private Property property = null;
	private volatile HashMap<String, ArrayList<PropertyListHolder>> listDecorateMap = new HashMap<String, ArrayList<PropertyListHolder>>();

	public void load(PropertyLoaderDetails propFileDetails)
			throws PropertyException, InterruptedException, ExecutionException {
		ArrayList<PropertyLoaderDetails> list = new ArrayList<PropertyLoaderDetails>();
		list.add(propFileDetails);
		load(list);
	}

	public void load(List<PropertyLoaderDetails> propFileDetailList)
			throws PropertyException, InterruptedException, ExecutionException {
		propertyLoadingThread(propFileDetailList);
	}

	private void propertyLoadingThread(
			List<PropertyLoaderDetails> propFileDetailList)
			throws InterruptedException, ExecutionException {
		property = new Property();
		Set<Future<PropertyLoaderObject>> set = new HashSet<Future<PropertyLoaderObject>>();
		long start = System.currentTimeMillis();
		ExecutorService executorPool = Executors
				.newFixedThreadPool(propFileDetailList.size());

		for (int index = 0; index < propFileDetailList.size(); index++) {

			Future<PropertyLoaderObject> future = executorPool
					.submit(new PropertyValueDecoratorThread(propFileDetailList
							.get(index), index));
			set.add(future);
		}
		Property propertyTemp = new Property();
		for (Future<PropertyLoaderObject> future : set) {
			// propertyTemp.putAll(future.get());
			PropertyLoaderObject object = future.get();

			listDecorateMap.putAll(object.getListHolderMap());

			this.property.putAll(object.getTempProperty());
		}
		System.out.println("listDecorateMap : " + listDecorateMap);
		/*
		 * if (propertyTemp != null && propertyTemp.size() > 0) { Set<Object>
		 * keySet = propertyTemp.keySet(); Iterator<Object> keySetIterator =
		 * keySet.iterator(); while (keySetIterator.hasNext()) { String key =
		 * (String) keySetIterator.next(); String propValue =
		 * PropertyFormatUtil.getInstance()
		 * .formatPropertyValue(propertyTemp.getProperty(key), propertyTemp);
		 * this.property.setProperty(key, propValue); } }
		 */

		System.out.println("Time to load : "
				+ (System.currentTimeMillis() - start));
	}

	public synchronized HashMap<String, ArrayList<PropertyListHolder>> getPropertyListHolder() {
		return listDecorateMap;
	}

	public void addPropertyListHolder(String key, PropertyListHolder listHolder) {
		synchronized (listDecorateMap) {
			ArrayList<PropertyListHolder> holderList = this.listDecorateMap
					.get(key);
			if (holderList == null) {
				holderList = new ArrayList<PropertyListHolder>();
			}
			holderList.add(listHolder);
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
