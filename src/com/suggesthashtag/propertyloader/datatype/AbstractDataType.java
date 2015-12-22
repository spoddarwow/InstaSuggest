/**
 * 
 */
package com.suggesthashtag.propertyloader.datatype;

/**
 * @author sumitpoddar
 *
 */
public interface AbstractDataType<T> {

	T getValue(String value);
}
