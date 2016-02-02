/**
 * 
 */
package com.suggesthashtag.propertyloader.decorateProp;

import java.util.Properties;

import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author sumitpoddar
 *
 */
public interface PropertyDecoratorInterface {

	boolean isCriteriaMetForThisDecorator(String value);

	<T> T decorateProperty(String value, Properties properties)
			throws PropertyException;
}
