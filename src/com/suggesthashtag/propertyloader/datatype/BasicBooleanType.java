/**
 * 
 */
package com.suggesthashtag.propertyloader.datatype;

/**
 * @author sumitpoddar
 *
 */
public class BasicBooleanType implements AbstractDataType<Boolean> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.suggesthashtag.propertyloader.datatype.AbstractDataType#getValue(
	 * java.lang.String)
	 */
	@Override
	public Boolean getValue(String value) {
		// TODO Auto-generated method stub
		return Boolean.valueOf(value);
	}

}
