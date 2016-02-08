/**
 * 
 */
package com.suggesthashtag.propertyloader.propertyDecorator;

import java.util.List;

import com.suggesthashtag.propertyloader.decorateProp.PropertyListHolder;

/**
 * @author sumitpoddar
 *
 */
public class LoadPropertyFromFilePropDecorator extends
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
	public LoadPropertyFromFilePropDecorator(
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
		String propertyListToLoad
		return decoratingObject;
	}

}
