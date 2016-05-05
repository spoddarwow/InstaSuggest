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
public abstract class AbstractLoggerEvents {

	protected Logger getLogger(String loggerName) {
		return Logger.getLogger(loggerName);
	}

	public abstract void log(String message);

	public abstract void log(String message, Throwable throwObject);

	public abstract void log(Class<? extends BasicLogObject> messageObject);

	public abstract void log(Class<? extends BasicLogObject> messageObject,
			Throwable throwObject);
}
