/**
 * 
 */
package com.suggesthashtag.logger.events;

import com.suggesthashtag.logger.BasicLogObject;

/**
 * @author sumitpoddar
 *
 */
public class LogEventFatalHandler extends AbstractLoggerEvents {

	private String loggerName = "";

	/**
	 * 
	 */
	public LogEventFatalHandler(String loggerName) {
		this.loggerName = loggerName;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.suggesthashtag.logger.events.AbstractLoggerEvents#log(java.lang.String
	 * )
	 */
	@Override
	public void log(String message) {
		// TODO Auto-generated method stub
		getLogger(loggerName).fatal(message);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.suggesthashtag.logger.events.AbstractLoggerEvents#log(java.lang.String
	 * , java.lang.Throwable)
	 */
	@Override
	public void log(String message, Throwable throwObject) {
		// TODO Auto-generated method stub
		getLogger(loggerName).fatal(message, throwObject);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.suggesthashtag.logger.events.AbstractLoggerEvents#log(java.lang.Class
	 * )
	 */
	@Override
	public void log(Class<? extends BasicLogObject> messageObject) {
		// TODO Auto-generated method stub
		getLogger(loggerName).fatal(messageObject);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.suggesthashtag.logger.events.AbstractLoggerEvents#log(java.lang.Class
	 * , java.lang.Throwable)
	 */
	@Override
	public void log(Class<? extends BasicLogObject> messageObject,
			Throwable throwObject) {
		// TODO Auto-generated method stub
		getLogger(loggerName).fatal(messageObject, throwObject);

	}

}
