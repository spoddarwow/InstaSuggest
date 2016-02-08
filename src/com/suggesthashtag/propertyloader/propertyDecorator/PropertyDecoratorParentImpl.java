/**
 * 
 */
package com.suggesthashtag.propertyloader.propertyDecorator;

/**
 * @author sumitpoddar
 *
 */
public class PropertyDecoratorParentImpl implements PropertyDecoratorInterface {

	private PropertyDecoratorObject thisPropertyDecoratorObject;

	/**
	 * @param thisPropertyDecoratorObject
	 */
	public PropertyDecoratorParentImpl(
			PropertyDecoratorObject thisPropertyDecoratorObject) {
		super();
		this.thisPropertyDecoratorObject = thisPropertyDecoratorObject;
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
		// TODO Auto-generated method stub
		return decoratingObject;
	}

}
