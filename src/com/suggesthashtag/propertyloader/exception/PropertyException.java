/**
 * 
 */
package com.suggesthashtag.propertyloader.exception;

/**
 * @author sumitpoddar
 *
 */
public class PropertyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PropertyException() {
		super();
	}

	public PropertyException(String exceptionMessage) {
		super(exceptionMessage);
	}

	public PropertyException(Throwable exceptionCause) {
		super(exceptionCause);
	}

	public PropertyException(String exceptionMessage, Throwable exceptionCause) {
		super(exceptionMessage, exceptionCause);
	}

}
