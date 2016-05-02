/**
 * 
 */
package com.suggesthashtag.propertyloader.propertyDecorator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;
import com.suggesthashtag.propertyloader.PropertyLoaderDetails;
import com.suggesthashtag.propertyloader.datatype.PropertyObjects;
import com.suggesthashtag.propertyloader.decorateProp.PropertyLoaderObject;
import com.suggesthashtag.propertyloader.decorateProp.PropertyObjectHolder;
import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author sumitpoddar
 *
 */
public class BuildObjectToPropertyPropDecorator extends
		PropertyDecoratorImplementation {

	private PropertyDecoratorInterface decoratorInterface;

	public PropertyDecoratorInterface getDecoratorInterface() {
		return this.decoratorInterface;
	}

	public void setDecoratorInterface(
			PropertyDecoratorInterface decoratorInterface) {
		this.decoratorInterface = decoratorInterface;
	}

	/**
	 * @param decoratorInterface
	 */
	public BuildObjectToPropertyPropDecorator(
			PropertyDecoratorInterface decoratorInterface) {

		super(decoratorInterface);
		this.decoratorInterface = decoratorInterface;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.suggesthashtag.propertyloader.propertyDecorator.
	 * PropertyDecoratorImplementation
	 * #processPropertyFiles(com.suggesthashtag.propertyloader
	 * .propertyDecorator.PropertyDecoratorObject)
	 */
	@Override
	public PropertyDecoratorObject processPropertyFiles(
			PropertyDecoratorObject decoratingObject) throws PropertyException {
		decoratingObject = super.processPropertyFiles(decoratingObject);
		Gson gsonBuilder = new Gson();
		if (decoratingObject != null
				&& !decoratingObject.getPropertyLoaderList().isEmpty()) {
			List<PropertyLoaderDetails> objectPropToProcess = decoratingObject
					.getPropertyLoaderList();
			for (int index = 0; index < objectPropToProcess.size(); index++) {
				PropertyLoaderDetails propertyFile = objectPropToProcess
						.get(index);
				PropertyLoaderObject propLoaderObject = decoratingObject
						.getProcessingPropertiesMap().get(
								propertyFile.toString());
				if (propLoaderObject != null
						&& propLoaderObject.getPropertyObjectHolderMap() != null
						&& propLoaderObject.getPropertyObjectHolderMap().size() > 0) {
					HashMap<String, PropertyObjectHolder> propertyObjectHolder = propLoaderObject
							.getPropertyObjectHolderMap();
					Set<String> keySet = propertyObjectHolder.keySet();
					Iterator<String> keySetIterator = keySet.iterator();
					while (keySetIterator.hasNext()) {
						String key = (String) keySetIterator.next();
						PropertyObjectHolder propListValue = propertyObjectHolder
								.get(key);
						if (propListValue.getJsonObjectClass() != null
								&& propListValue.getValues() != null) {
							gsonBuilder = new Gson();
							Class<? extends PropertyObjects> jsonClazz;
							try {
								jsonClazz = (Class<? extends PropertyObjects>) Class
										.forName(decoratingObject
												.getFinalProperty()
												.getProperty(
														propListValue
																.getJsonObjectClass()));
							} catch (ClassNotFoundException exception) {
								// TODO Auto-generated catch block
								exception.printStackTrace();
								throw new PropertyException(
										exception.getMessage());
							}

							decoratingObject.getFinalProperty().put(
									key,
									gsonBuilder.fromJson(
											propListValue.getValues(),
											jsonClazz));
						}

					}
				}
			}

		}

		return decoratingObject;
	}
}
