/**
 * 
 */
package com.suggesthashtag.logger;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.suggesthashtag.logger.exception.LoggerException;
import com.suggesthashtag.propertyloader.PropertyLoader;

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

	// TODO: logger pool implementation.
	/*
	 * private static Stack<Logger> unusedLoggers = new Stack<Logger>(); private
	 * static Stack<Logger> usedLoggers = new Stack<Logger>(); private static
	 * int maxLogger = LoggerConstant.DEF_LOGGER_OBJ_COUNT;
	 */

	/**
	 * To be implemented as improvement.
	 */
	public static void initLogger(String batchName, Properties properties)
			throws LoggerException {
		if (batchName == null || "".equals(batchName)) {
			throw new LoggerException(
					"BatchName cannot be null/empty. It is used for logger reference.");
		}
		Logger logger = Logger.getLogger(batchName);
		PropertyConfigurator.configure(properties);
		log("---- Logger object (" + batchName + ") is ready. ----");
	}

	public static void log(String message) {
		log(LoggerLevel.INFO, message);
	}

	public static void log(LoggerLevel level, String message) {
		LoggerFactory.getInstance()
				.getLoggerEventHandler(getLoggerName(), level).log(message);
	}

	public static void log(String message, Throwable throwObject) {
		log(LoggerLevel.INFO, message, throwObject);
	}

	public static void log(LoggerLevel level, String message,
			Throwable throwObject) {
		LoggerFactory.getInstance()
				.getLoggerEventHandler(getLoggerName(), level).log(message);
	}

	public static void log(Class<? extends BasicLogObject> message) {
		log(LoggerLevel.INFO, message);
	}

	public static void log(LoggerLevel level,
			Class<? extends BasicLogObject> message) {
		LoggerFactory.getInstance()
				.getLoggerEventHandler(getLoggerName(), level).log(message);
	}

	public static void log(Class<? extends BasicLogObject> message,
			Throwable throwObject) {
		log(LoggerLevel.INFO, message, throwObject);
	}

	public static void log(LoggerLevel level,
			Class<? extends BasicLogObject> message, Throwable throwObject) {
		LoggerFactory.getInstance()
				.getLoggerEventHandler(getLoggerName(), level).log(message);
	}

	public static String getLoggerName() {
		return "SHTMediaPopularRequestHandler";
	}
}
