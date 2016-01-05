/**
 * 
 */
package com.suggesthashtag.logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
public abstract class LogManager {

	protected static String batchName = "";

	private LogManager() {
	}

	/**
	 * @param batchName
	 */
	public LogManager(String batchName) {
		this.batchName = batchName;

	}

	// TODO: logger pool implementation.
	/*
	 * private static Stack<Logger> unusedLoggers = new Stack<Logger>(); private
	 * static Stack<Logger> usedLoggers = new Stack<Logger>(); private static
	 * int maxLogger = LoggerConstant.DEF_LOGGER_OBJ_COUNT;
	 */

	/**
	 * To be implemented as improvement.
	 */
	public void init(Properties loggerPropertyConf) throws LoggerException {
		if (batchName == null || "".equals(batchName)) {
			throw new LoggerException(
					"BatchName cannot be null/empty. It is used for logger reference.");
		}
		Logger logger = Logger.getLogger(batchName);
		if (loggerPropertyConf.getProperty("log.filename").contains("{")
				&& loggerPropertyConf.getProperty("log.filename").contains("}")) {
			Calendar cal = Calendar.getInstance();
			String formatLoggerFileName = formatLoggerFileName(loggerPropertyConf
					.getProperty("log.filename"));

			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"dd/MMM/yyyy_HH:mm:ss");
			System.out.println(dateFormat.format(cal.getTime()));
			loggerPropertyConf.setProperty("log.filename", "");
		}
		PropertyConfigurator.configure(loggerPropertyConf);
		log("---- Logger object (" + batchName + ") is ready.");
	}

	/**
	 * @param property
	 * @return
	 */
	private String formatLoggerFileName(String loggerFileName) {
		String newLoggerFileName = loggerFileName;
		
		return newLoggerFileName;
	}

	public void log(String message) {
		log(LoggerLevel.INFO, message);
	}

	public void log(LoggerLevel level, String message) {
		LoggerFactory.getInstance()
				.getLoggerEventHandler(getLoggerName(), level).log(message);
	}

	public void log(String message, Throwable throwObject) {
		log(LoggerLevel.INFO, message, throwObject);
	}

	public void log(LoggerLevel level, String message, Throwable throwObject) {
		LoggerFactory.getInstance()
				.getLoggerEventHandler(getLoggerName(), level).log(message);
	}

	public void log(Class<? extends BasicLogObject> message) {
		log(LoggerLevel.INFO, message);
	}

	public void log(LoggerLevel level, Class<? extends BasicLogObject> message) {
		LoggerFactory.getInstance()
				.getLoggerEventHandler(getLoggerName(), level).log(message);
	}

	public void log(Class<? extends BasicLogObject> message,
			Throwable throwObject) {
		log(LoggerLevel.INFO, message, throwObject);
	}

	public void log(LoggerLevel level, Class<? extends BasicLogObject> message,
			Throwable throwObject) {
		LoggerFactory.getInstance()
				.getLoggerEventHandler(getLoggerName(), level).log(message);
	}

	public abstract String getLoggerName();
}
