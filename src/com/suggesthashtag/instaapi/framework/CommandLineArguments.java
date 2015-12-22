package com.suggesthashtag.instaapi.framework;

import java.util.HashMap;

/**
 * Class to read the command line argument and build it for easy process.
 * 
 * @author sumitpoddar
 *
 */
public class CommandLineArguments {

	private HashMap<String, String> commandLineArgs = new HashMap<String, String>();

	public CommandLineArguments(String[] args) {
		buildCommandLineArgs(args);
	}

	private void buildCommandLineArgs(String[] args) {
		if ((args != null) && (args.length > 0) && ((args.length & 1) == 0)) {
			int index = 0;
			while (index < args.length) {
				commandLineArgs.put(args[index], args[index + 1]);
				index += 2;
			}
		}
	}

	public String getCommandArgument(String argumentKey) {
		return commandLineArgs.get(argumentKey);
	}
}
