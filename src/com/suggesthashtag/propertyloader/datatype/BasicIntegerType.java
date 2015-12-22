/**
 * 
 */
package com.suggesthashtag.propertyloader.datatype;

/**
 * @author sumitpoddar
 *
 */
public class BasicIntegerType implements AbstractDataType<Integer> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.suggesthashtag.propertyloader.datatype.AbstractDataType#getValue(
	 * java.lang.String)
	 */
	@Override
	public Integer getValue(String value) {
		// TODO Auto-generated method stub
		return Integer.valueOf(value);
	}

}
