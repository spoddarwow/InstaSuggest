/**
 * 
 */
package com.suggesthashtag.instaapi.httpconnection;

import com.suggesthashtag.instaapi.framework.exception.SHTMainException;

/**
 * @author sumitpoddar
 *
 */
public class HttpConnectionException extends SHTMainException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HttpConnectionException() {
		super();
	}

	public HttpConnectionException(String exceptionMessage) {
		super(exceptionMessage);
	}

	public HttpConnectionException(Throwable exceptionCause) {
		super(exceptionCause);
	}

	public HttpConnectionException(String exceptionMessage,
			Throwable exceptionCause) {
		super(exceptionMessage, exceptionCause);
	}

}
