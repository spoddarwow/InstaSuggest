package com.suggesthashtag.instaapi.framework;

import com.suggesthashtag.logger.LogManager;
import com.suggesthashtag.propertyloader.PropertyLoader;

/**
 * Main batch processing class.
 * 
 * @author sumitpoddar
 *
 */
public class SHTMainApp extends LogManager {

	protected static PropertyLoader propertyLoader = null;
	protected static CommandLineArguments commandLinesArgs = null;

	/**
	 * @param batchName
	 */
	public SHTMainApp(String batchName) {
		super(batchName);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.suggesthashtag.logger.LogManager#getLoggerName()
	 */
	@Override
	public String getLoggerName() {
		// TODO Auto-generated method stub
		return super.batchName;
	}

	public static PropertyLoader getPropertyLoader() {
		return propertyLoader;
	}

	public static CommandLineArguments getCommandLinesArgs() {
		return commandLinesArgs;
	}

}
