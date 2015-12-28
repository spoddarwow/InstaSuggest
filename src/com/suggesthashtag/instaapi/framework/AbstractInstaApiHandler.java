package com.suggesthashtag.instaapi.framework;

import java.util.ArrayList;
import java.util.List;

import com.suggesthashtag.logger.BatchLogManager;
import com.suggesthashtag.logger.exception.LoggerException;
import com.suggesthashtag.propertyloader.PropertyLoader;
import com.suggesthashtag.propertyloader.PropertyLoaderDetails;
import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * Abstract class used for all the Instagram API's
 * 
 * @author sumitpoddar
 *
 */
public abstract class AbstractInstaApiHandler extends BatchLogManager {

	/**
	 * @param batchName
	 */
	public AbstractInstaApiHandler(String batchName) {
		super(batchName);
		// TODO Auto-generated constructor stub
	}

	private PropertyLoader propertyLoader = new PropertyLoader();
	private CommandLineArguments commandLinesArgs = null;

	public void process(Class<? extends AbstractInstaApiHandler> callerClass,
			String[] args) {
		try {
			System.out.println("----- Starting with the batch process : "
					+ callerClass.getName());
			System.out.println("Loading Command Line arguments");
			commandLinesArgs = new CommandLineArguments(args);
			System.out
					.println("Command Line arguments loaded. Starting with loading properties file(s)");
			loadPropertyFile();
			init();
			log("Properties file(s) loaded. Starting with execution of the process.");
			execute();
			log("Execution complete.");
		} catch (PropertyException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
			System.exit(1);
		} catch (LoggerException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}
		log("Batch process for " + callerClass.getName()
				+ " is finished successfully.");
	}

	public CommandLineArguments getCommandLineArgs() {
		return this.commandLinesArgs;
	}

	protected void loadPropertyFile() throws PropertyException {
		if (loadMainPropertyFile()) {
			List<PropertyLoaderDetails> tempList = new ArrayList<PropertyLoaderDetails>();
			tempList.add(new PropertyLoaderDetails("batchMain.properties",
					false));
			if (getPropertyLoadDetailsList() != null
					&& getPropertyLoadDetailsList().size() > 0) {
				tempList.addAll(getPropertyLoadDetailsList());
				propertyLoader.load(tempList);
			} else {
				tempList.add(getPropertyLoadDetails());
				propertyLoader.load(getPropertyLoadDetails());
			}
		} else {
			if (getPropertyLoadDetailsList() != null
					&& getPropertyLoadDetailsList().size() > 0) {
				propertyLoader.load(getPropertyLoadDetailsList());
			} else {
				propertyLoader.load(getPropertyLoadDetails());
			}
		}

	}

	public abstract void execute();

	public abstract boolean loadMainPropertyFile();

	public abstract PropertyLoaderDetails getPropertyLoadDetails();

	public abstract List<PropertyLoaderDetails> getPropertyLoadDetailsList();
}
