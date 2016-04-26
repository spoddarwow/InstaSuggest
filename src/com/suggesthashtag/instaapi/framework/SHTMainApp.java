package com.suggesthashtag.instaapi.framework;

import com.suggesthashtag.propertyloader.PropertyLoader;

/**
 * Main batch processing class.
 * 
 * @author sumitpoddar
 *
 */
public class SHTMainApp {

	protected static PropertyLoader propertyLoader = null;
	protected static CommandLineArguments commandLinesArgs = null;

	public static PropertyLoader getPropertyLoader() {
		return propertyLoader;
	}

	public static void setPropertyLoader(PropertyLoader propertyLoader) {
		SHTMainApp.propertyLoader = propertyLoader;
	}

	public static CommandLineArguments getCommandLinesArgs() {
		return commandLinesArgs;
	}

	public static void setCommandLinesArgs(CommandLineArguments commandLinesArgs) {
		SHTMainApp.commandLinesArgs = commandLinesArgs;
	}

}
