/**
 * 
 */
package com.suggesthashtag.logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.suggesthashtag.instaapi.framework.MainObjectHolder;
import com.suggesthashtag.instaapi.framework.SHTMainApp;
import com.suggesthashtag.logger.exception.LoggerException;

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

	protected String batchName = "";

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
	public void initLogger() throws LoggerException {
		if (batchName == null || "".equals(batchName)) {
			throw new LoggerException(
					"BatchName cannot be null/empty. It is used for logger reference.");
		}
		Properties loggerPropertyConf = SHTMainApp.getPropertyLoader()
				.getProperty();
		Logger logger = Logger.getLogger(batchName);
		if (loggerPropertyConf.getProperty("log4j.appender.FILE.File")
				.contains("{")
				&& loggerPropertyConf.getProperty("log4j.appender.FILE.File")
						.contains("}")) {

			String formatLoggerFileName = formatLoggerFileName(loggerPropertyConf
					.getProperty("log4j.appender.FILE.File"));
			loggerPropertyConf.remove("log4j.appender.FILE.File");
			loggerPropertyConf.put("log4j.appender.FILE.File",
					formatLoggerFileName);
		}
		PropertyConfigurator.configure(loggerPropertyConf);
		log("---- Logger object (" + batchName + ") is ready.");
	}

	/**
	 * @param property
	 * @return
	 * @throws LoggerException
	 */
	private String formatLoggerFileName(String loggerFileName)
			throws LoggerException {
		char[] loggerFileNameChar = loggerFileName.toCharArray();
		boolean isOpen = false;
		StringBuffer str = new StringBuffer();
		StringBuffer newLoggerFileName = new StringBuffer();
		for (Character character : loggerFileNameChar) {
			if (character == '{') {
				if (isOpen) {
					throw new LoggerException("Invalid logger name pattern.");
				}
				str = new StringBuffer();
				isOpen = true;
			} else if (character == '}') {
				if (!isOpen) {
					throw new LoggerException("Invalid logger name pattern.");
				}
				isOpen = false;
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						str.toString());
				Calendar cal = Calendar.getInstance();
				newLoggerFileName.append(dateFormat.format(cal.getTime()));
			} else if (isOpen) {
				str.append(character);
			} else {
				newLoggerFileName.append(character);
			}
		}

		return newLoggerFileName.toString();
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
