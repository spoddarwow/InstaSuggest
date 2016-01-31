/**
 * 
 */
package com.suggesthashtag.propertyloader.decorateProp;

import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author sumitpoddar
 *
 */
public interface PropertyDecoratorInterface {

	boolean isCriteriaMetForThisDecorator(String value);

	<T> T decorateProperty(String value) throws PropertyException;
}
