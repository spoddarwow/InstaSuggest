/**
 * 
 */
package com.suggesthashtag.propertyloader.datatype;

/**
 * @author sumitpoddar
 *
 */
public class BasicFloatType implements AbstractDataType<Float> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.suggesthashtag.propertyloader.datatype.AbstractDataType#getValue(
	 * java.lang.String)
	 */
	@Override
	public Float getValue(String value) {
		// TODO Auto-generated method stub
		return Float.valueOf(value);
	}

}
