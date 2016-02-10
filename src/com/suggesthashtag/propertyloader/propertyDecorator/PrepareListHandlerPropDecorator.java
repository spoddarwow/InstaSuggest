/**
 * 
 */
package com.suggesthashtag.propertyloader.propertyDecorator;

import java.util.Iterator;
import java.util.Set;

import com.suggesthashtag.propertyloader.Property;
import com.suggesthashtag.propertyloader.PropertyFormatUtil;
import com.suggesthashtag.propertyloader.PropertyLoaderDetails;
import com.suggesthashtag.propertyloader.decorateProp.PropertyLoaderObject;

/**
 * @author sumitpoddar
 *
 */
public class PrepareListHandlerPropDecorator extends
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
	public PrepareListHandlerPropDecorator(
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
			PropertyDecoratorObject decoratingObject) {
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
						&& propLoaderObject.getTempProperty() != null
						&& propLoaderObject.getTempProperty().size() > 0) {
					Property property = propLoaderObject.getTempProperty();
					Set<Object> keySet = property.keySet();
					Iterator<Object> keySetIterator = keySet.iterator();
					while (keySetIterator.hasNext()) {
						String key = (String) keySetIterator.next();
						String propValue = property.getProperty(key);
						if (propValue.toUpperCase().startsWith("LIST<")) {

							/*
							 * listHolderMap.put( key,
							 * PropertyFormatUtil.getInstance()
							 * .formatPropertyValueForListType(
							 * property.getProperty(key), property));
							 */
						} else {
							decoratingObject.getFinalProperty().setProperty(
									key, property.getProperty(key));
						}
					}
				}
			}

		}

		return decoratingObject;
	}
}
