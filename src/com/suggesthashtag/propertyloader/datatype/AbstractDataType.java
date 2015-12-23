/**
 * 
 */
package com.suggesthashtag.propertyloader.datatype;

import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author sumitpoddar
 *
 */
public interface AbstractDataType<T> {

	T getValue(String value) throws PropertyException;
}
