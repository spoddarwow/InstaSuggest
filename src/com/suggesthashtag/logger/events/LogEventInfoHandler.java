/**
 * 
 */
package com.suggesthashtag.logger.events;

import org.apache.log4j.Logger;

import com.suggesthashtag.logger.BasicLogObject;

/**
 * @author sumitpoddar
 *
 */
public class LogEventInfoHandler extends AbstractLoggerEvents {

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
		Logger logger = getLogger();
		if (logger.isInfoEnabled()) {
			logger.info(message);
		}
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
		Logger logger = getLogger();
		if (logger.isInfoEnabled()) {
			logger.info(message, throwObject);
		}
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
		Logger logger = getLogger();
		if (logger.isInfoEnabled()) {
			logger.info(messageObject);
		}
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
		Logger logger = getLogger();
		if (logger.isInfoEnabled()) {
			logger.info(messageObject, throwObject);
		}
	}

}
