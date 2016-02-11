/**
 * 
 */
package com.suggesthashtag.propertyloader.propertyDecorator;

import java.util.Iterator;
import java.util.Set;

import com.suggesthashtag.propertyloader.Property;
import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author sumitpoddar
 *
 */
public class BuildPropertyValuesPropDecorator extends
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
	public BuildPropertyValuesPropDecorator(
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
				&& decoratingObject.getFinalProperty() != null
				&& !decoratingObject.getFinalProperty().isEmpty()) {
			Property property = decoratingObject.getFinalProperty();
			Set<Object> keySet = property.keySet();
			Iterator<Object> keySetIterator = keySet.iterator();
			while (keySetIterator.hasNext()) {
				String key = (String) keySetIterator.next();
				decoratingObject.getFinalProperty().setProperty(key,
						property.extractNFormatPropertyValue(key));
			}

		}

		return decoratingObject;
	}

}
