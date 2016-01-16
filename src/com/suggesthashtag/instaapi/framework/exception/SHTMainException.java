/**
 * 
 */
package com.suggesthashtag.instaapi.framework.exception;

/**
 * @author sumitpoddar
 *
 */
public class SHTMainException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SHTMainException() {
		super();
	}

	public SHTMainException(String exceptionMessage) {
		super(exceptionMessage);
	}

	public SHTMainException(Throwable exceptionCause) {
		super(exceptionCause);
	}

	public SHTMainException(String exceptionMessage, Throwable exceptionCause) {
		super(exceptionMessage, exceptionCause);
	}

}