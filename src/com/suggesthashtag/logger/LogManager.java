/**
 * 
 */
package com.suggesthashtag.logger;

import org.apache.log4j.Logger;

/**
 * Singleton class for managing logs. Improvements to do:
 * <ul>
 * <li>Logger Pool using stack.</li>
 * <li>Push sysouts/syserr to log</li>
 * <li>Implement Class<? extends BasicLogObject></li>
 * </ul>
 * 
 * @author sumitpoddar
 *
 */
public class LogManager {

	private static LogManager MY_INSTANCE = new LogManager();

	public static LogManager getInstance() {
		return MY_INSTANCE;
	}

	// TODO: logger pool implementation.
	/*
	 * private static Stack<Logger> unusedLoggers = new Stack<Logger>(); private
	 * static Stack<Logger> usedLoggers = new Stack<Logger>(); private static
	 * int maxLogger = LoggerConstant.DEF_LOGGER_OBJ_COUNT;
	 */

	private LogManager() {
		init();
	}

	/**
	 * To be implemented as improvement.
	 */
	private void init() {
		Logger logger = Logger.getLogger(LoggerConstant.MAIN_LOGGER_NAME);
		logger.info("------ Logger is ready! ------");
	}

	public void log(String message) {
		log(LoggerLevel.INFO, message);
	}

	public void log(LoggerLevel level, String message) {
		LoggerFactory.getInstance().getLoggerEventHandler(level).log(message);
	}

	public void log(String message, Throwable throwObject) {
		log(LoggerLevel.INFO, message, throwObject);
	}

	public void log(LoggerLevel level, String message, Throwable throwObject) {
		LoggerFactory.getInstance().getLoggerEventHandler(level).log(message);
	}

	public void log(Class<? extends BasicLogObject> message) {
		log(LoggerLevel.INFO, message);
	}

	public void log(LoggerLevel level, Class<? extends BasicLogObject> message) {
		LoggerFactory.getInstance().getLoggerEventHandler(level).log(message);
	}

	public void log(Class<? extends BasicLogObject> message,
			Throwable throwObject) {
		log(LoggerLevel.INFO, message, throwObject);
	}

	public void log(LoggerLevel level, Class<? extends BasicLogObject> message,
			Throwable throwObject) {
		LoggerFactory.getInstance().getLoggerEventHandler(level).log(message);
	}
}
