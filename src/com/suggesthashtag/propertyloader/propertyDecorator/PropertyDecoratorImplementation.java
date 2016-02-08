/**
 * 
 */
package com.suggesthashtag.propertyloader.propertyDecorator;

/**
 * @author sumitpoddar
 *
 */
public class PropertyDecoratorImplementation implements
		PropertyDecoratorInterface {

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
	public PropertyDecoratorImplementation(
			PropertyDecoratorInterface decoratorInterface) {
		super();
		this.decoratorInterface = decoratorInterface;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.suggesthashtag.propertyloader.propertyDecorator.
	 * PropertyDecoratorInterface#processPropertyFiles()
	 */
	@Override
	public PropertyDecoratorObject processPropertyFiles(
			PropertyDecoratorObject decoratingObject) {
		return decoratingObject;
	}

}
