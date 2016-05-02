package com.suggesthashtag.instaapi.framework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.suggesthashtag.db.exception.DBException;
import com.suggesthashtag.db.hibernate.DBConnectionInit;
import com.suggesthashtag.logger.LogManager;
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
public abstract class AbstractSHTBatchHandler extends LogManager {

	protected static PropertyLoader propertyLoader = null;
	protected static CommandLineArguments commandLinesArgs = null;

	/**
	 * @param batchName
	 */
	public AbstractSHTBatchHandler(String batchName) {
		super(batchName);
		// TODO Auto-generated constructor stub
	}

	public void process(Class<? extends AbstractSHTBatchHandler> callerClass,
			String[] args) {
		try {
			System.out.println(System.out.getClass().getName());
			System.out.println("----- Starting with the batch process : "
					+ callerClass.getName());
			System.out.println("Loading Command Line arguments");
			commandLinesArgs = new CommandLineArguments(args);
			System.out
					.println("Command Line arguments loaded. Starting with loading properties file(s)");
			propertyLoader = new PropertyLoader();
			loadPropertyFile();
			SHTMainApp.setPropertyLoader(propertyLoader);
			SHTMainApp.setCommandLinesArgs(commandLinesArgs);
			initLogger();
			log("Properties file(s) loaded. Starting with execution of the process.");
			DBConnectionInit.init();
			log("Properties file(s) loaded. Starting with execution of the process.");
			execute();
			log("Execution complete.");
		} catch (PropertyException | LoggerException | InterruptedException
				| ExecutionException | DBException | ClassNotFoundException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
			System.exit(1);
		}
		log("Batch process for " + callerClass.getName()
				+ " is finished successfully.");
	}

	protected void loadPropertyFile() throws PropertyException,
			InterruptedException, ExecutionException {
		if (loadMainPropertyFile()) {
			List<PropertyLoaderDetails> tempList = new ArrayList<PropertyLoaderDetails>();
			tempList.addAll(getALlMainPropertyFiles());
			if (getPropertyLoadDetailsList() != null
					&& getPropertyLoadDetailsList().size() > 0) {
				tempList.addAll(getPropertyLoadDetailsList());
			} else if (getPropertyLoadDetails() != null) {
				tempList.add(getPropertyLoadDetails());
			}
			propertyLoader.load(tempList);
		} else {
			if (getPropertyLoadDetailsList() != null
					&& getPropertyLoadDetailsList().size() > 0) {
				propertyLoader.load(getPropertyLoadDetailsList());
			} else if (getPropertyLoadDetails() != null) {
				propertyLoader.load(getPropertyLoadDetails());
			}
		}
		MainObjectHolder.setPropertyLoader(propertyLoader);
	}

	protected ArrayList<PropertyLoaderDetails> getALlMainPropertyFiles() {
		ArrayList<PropertyLoaderDetails> tempList = new ArrayList<PropertyLoaderDetails>();
		tempList.add(new PropertyLoaderDetails("classes.properties",
				"universal"));
		tempList.add(new PropertyLoaderDetails("batchMain.properties"));
		tempList.add(new PropertyLoaderDetails("db.properties"));
		return tempList;
	}

	public boolean loadMainPropertyFile() {
		return true;
	}

	public abstract void execute();

	public abstract PropertyLoaderDetails getPropertyLoadDetails();

	public abstract List<PropertyLoaderDetails> getPropertyLoadDetailsList();

}
