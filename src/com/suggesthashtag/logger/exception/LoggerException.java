/**
 * 
 */
package com.suggesthashtag.logger.exception;

/**
 * @author sumitpoddar
 *
 */
public class LoggerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoggerException() {
		super();
	}

	public LoggerException(String exceptionMessage) {
		super(exceptionMessage);
	}

	public LoggerException(Throwable exceptionCause) {
		super(exceptionCause);
	}

	public LoggerException(String exceptionMessage, Throwable exceptionCause) {
		super(exceptionMessage, exceptionCause);
	}

}
