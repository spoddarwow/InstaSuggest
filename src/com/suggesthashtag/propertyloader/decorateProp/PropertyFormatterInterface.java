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
public interface PropertyFormatterInterface {


	<T> T formatPropertyValue(String value, Properties properties)
			throws PropertyException;
}
