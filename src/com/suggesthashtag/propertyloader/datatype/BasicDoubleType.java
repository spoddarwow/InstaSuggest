/**
 * 
 */
package com.suggesthashtag.propertyloader.datatype;

/**
 * @author sumitpoddar
 *
 */
public class BasicDoubleType implements AbstractDataType<Double> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.suggesthashtag.propertyloader.datatype.AbstractDataType#getValue(
	 * java.lang.String)
	 */
	@Override
	public Double getValue(String value) {
		// TODO Auto-generated method stub
		return Double.valueOf(value);
	}

}
