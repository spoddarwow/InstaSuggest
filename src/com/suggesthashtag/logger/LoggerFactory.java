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

	protected AbstractLoggerEvents getLoggerEventHandler(LoggerLevel loggerLevel) {
		AbstractLoggerEvents loggerEventHandler = new LogEventInfoHandler();
		if (loggerLevel != null) {
			switch (loggerLevel) {
			case INFO:
				// Already initialized above.
				break;
			case ERROR:
				loggerEventHandler = new LogEventErrorHandler();
				break;
			case TRACE:
				loggerEventHandler = new LogEventTraceHandler();
				break;
			case FATAL:
				loggerEventHandler = new LogEventFatalHandler();
				break;
			case WARN:
				loggerEventHandler = new LogEventWarnHandler();
				break;
			case DEBUG:
				loggerEventHandler = new LogEventDebugHandler();
				break;
			default:
				// Already initialized above.
				break;
			}
		}
		return loggerEventHandler;
	}
}
