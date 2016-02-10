/**
 * 
 */
package com.suggesthashtag.propertyloader.decorateProp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;

import com.suggesthashtag.propertyloader.Property;
import com.suggesthashtag.propertyloader.PropertyFormatUtil;
import com.suggesthashtag.propertyloader.PropertyLoader;
import com.suggesthashtag.propertyloader.PropertyLoaderDetails;

/**
 * @author sumitpoddar
 *
 */
public class PropertyValueDecoratorThread implements
		Callable<PropertyLoaderObject> {

	private PropertyLoaderDetails propFileDetails;
	private int index;

	/**
	 * @param threadIndex
	 * @param propFileDetails
	 * @param threadName
	 */
	public PropertyValueDecoratorThread(PropertyLoaderDetails propFileDetails,
			int index) {
		super();
		this.propFileDetails = propFileDetails;
		this.index = index;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public PropertyLoaderObject call() throws Exception {
		PropertyLoaderObject loaderObject = new PropertyLoaderObject();
		loaderObject.setIndex(this.index);
		HashMap<String, PropertyListHolder> listHolderMap = new HashMap<String, PropertyListHolder>();
		Property tempProperty = new Property();
		try {
			InputStream inputStream = PropertyLoader.class.getClassLoader()
					.getResourceAsStream(propFileDetails.toString());
			if (inputStream != null) {
				Property property = new Property();
				tempProperty.load(inputStream);
				if (property != null && property.size() > 0) {
					Set<Object> keySet = property.keySet();
					Iterator<Object> keySetIterator = keySet.iterator();
					while (keySetIterator.hasNext()) {
						String key = (String) keySetIterator.next();
						String propValue = PropertyFormatUtil.getInstance()
								.formatPropertyValue(property.getProperty(key),
										property);
						if (propValue.toUpperCase().startsWith("LIST<")) {
							listHolderMap.put(
									key,
									PropertyFormatUtil.getInstance()
											.formatPropertyValueForListType(
													property.getProperty(key),
													property));
						}
						tempProperty.setProperty(key, propValue);
					}
				}
				loaderObject.setTempProperty(tempProperty);
			} else {
				throw new FileNotFoundException("Property file "
						+ propFileDetails.toString()
						+ " not found in the classpath");
			}
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		return loaderObject;
	}

}