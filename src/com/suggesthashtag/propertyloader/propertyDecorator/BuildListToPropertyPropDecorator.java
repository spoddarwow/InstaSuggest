/**
 * 
 */
package com.suggesthashtag.propertyloader.propertyDecorator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.suggesthashtag.propertyloader.PropertyLoaderDetails;
import com.suggesthashtag.propertyloader.decorateProp.PropertyListHolder;
import com.suggesthashtag.propertyloader.decorateProp.PropertyLoaderObject;
import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author sumitpoddar
 *
 */
public class BuildListToPropertyPropDecorator extends
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
	public BuildListToPropertyPropDecorator(
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
		if (decoratingObject != null
				&& !decoratingObject.getPropertyLoaderList().isEmpty()) {
			for (int index = 0; index < decoratingObject
					.getPropertyLoaderList().size(); index++) {
				PropertyLoaderDetails propertyFile = decoratingObject
						.getPropertyLoaderList().get(index);
				PropertyLoaderObject propLoaderObject = decoratingObject
						.getProcessingPropertiesMap().get(
								propertyFile.toString());
				if (propLoaderObject != null
						&& propLoaderObject.getListHolderMap() != null
						&& propLoaderObject.getListHolderMap().size() > 0) {
					HashMap<String, PropertyListHolder> propertyListHolder = propLoaderObject
							.getListHolderMap();
					Set<String> keySet = propertyListHolder.keySet();
					Iterator<String> keySetIterator = keySet.iterator();
					while (keySetIterator.hasNext()) {
						String key = (String) keySetIterator.next();
						PropertyListHolder propListValue = propertyListHolder
								.get(key);
						if (propListValue.getListTypeClass() != null
								&& propListValue.getValues() != null) {
							List valueAsList = (List) decoratingObject
									.getFinalProperty().get(key);
							if (valueAsList == null) {
								valueAsList = propListValue.getListTypeClass()
										.getListPropertyLoader()
										.initializeArrayList();
							}
							String listValues = propListValue.getValues();
							String[] listValueSplit = listValues.split(",");
							for (String listValue : listValueSplit) {
								valueAsList.add(propListValue
										.getListTypeClass()
										.getParserDataTypeClass()
										.getValue(listValue.trim()));
							}
							decoratingObject.getFinalProperty().put(key,
									valueAsList);
						}

					}
				}
			}

		}

		return decoratingObject;
	}
}
