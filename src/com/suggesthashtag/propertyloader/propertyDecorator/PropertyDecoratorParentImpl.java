/**
 * 
 */
package com.suggesthashtag.propertyloader.propertyDecorator;

import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author sumitpoddar
 *
 */
public class PropertyDecoratorParentImpl implements PropertyDecoratorInterface {

	private PropertyDecoratorObject thisPropertyDecoratorObject;

	/**
	 * @param thisPropertyDecoratorObject
	 */
	public PropertyDecoratorParentImpl() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.suggesthashtag.propertyloader.propertyDecorator.
	 * PropertyDecoratorInterface#processPropertyFiles()
	 */
	@Override
	public PropertyDecoratorObject processPropertyFiles(
			PropertyDecoratorObject decoratingObject) throws PropertyException {
		// TODO Auto-generated method stub
		return decoratingObject;
	}

}
