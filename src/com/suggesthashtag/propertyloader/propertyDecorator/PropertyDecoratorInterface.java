/**
 * 
 */
package com.suggesthashtag.propertyloader.propertyDecorator;

import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author sumitpoddar
 *
 */
public interface PropertyDecoratorInterface {

	PropertyDecoratorObject processPropertyFiles(
			PropertyDecoratorObject decoratingObject) throws PropertyException;
}
