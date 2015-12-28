/**
 * 
 */
package com.suggesthashtag.logger;

import com.suggesthashtag.logger.events.AbstractLoggerEvents;
import com.suggesthashtag.logger.events.LogEventDebugHandler;
import com.suggesthashtag.logger.events.LogEventErrorHandler;
import com.suggesthashtag.logger.events.LogEventFatalHandler;
import com.suggesthashtag.logger.events.LogEventInfoHandler;
import com.suggesthashtag.logger.events.LogEventTraceHandler;
import com.suggesthashtag.logger.events.LogEventWarnHandler;

/**
 * @author sumitpoddar
 *
 */
public class LoggerFactory {

	private static LoggerFactory MY_INSTANCE = new LoggerFactory();

	private LoggerFactory() {

	}

	public static LoggerFactory getInstance() {
		return MY_INSTANCE;
	}

	protected AbstractLoggerEvents getLoggerEventHandler(String loggerName,
			LoggerLevel loggerLevel) {
		AbstractLoggerEvents loggerEventHandler = new LogEventInfoHandler(
				loggerName);
		if (loggerLevel != null) {
			switch (loggerLevel) {
			case INFO:
				// Already initialized above.
				break;
			case ERROR:
				loggerEventHandler = new LogEventErrorHandler(loggerName);
				break;
			case TRACE:
				loggerEventHandler = new LogEventTraceHandler(loggerName);
				break;
			case FATAL:
				loggerEventHandler = new LogEventFatalHandler(loggerName);
				break;
			case WARN:
				loggerEventHandler = new LogEventWarnHandler(loggerName);
				break;
			case DEBUG:
				loggerEventHandler = new LogEventDebugHandler(loggerName);
				break;
			default:
				// Already initialized above.
				break;
			}
		}
		return loggerEventHandler;
	}
}
