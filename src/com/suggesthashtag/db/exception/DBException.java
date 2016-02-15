/**
 * 
 */
package com.suggesthashtag.db.exception;

/**
 * @author sumitpoddar
 *
 */
public class DBException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DBException() {
		super();
	}

	public DBException(String exceptionMessage) {
		super(exceptionMessage);
	}

	public DBException(Throwable exceptionCause) {
		super(exceptionCause);
	}

	public DBException(String exceptionMessage, Throwable exceptionCause) {
		super(exceptionMessage, exceptionCause);
	}

}
