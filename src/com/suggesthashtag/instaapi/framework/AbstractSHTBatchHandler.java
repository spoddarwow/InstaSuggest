package com.suggesthashtag.instaapi.framework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.suggesthashtag.db.exception.DBException;
import com.suggesthashtag.db.hibernate.DBConnectionInit;
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
public abstract class AbstractSHTBatchHandler extends SHTMainApp {

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
			initLogger(propertyLoader.getProperty());
			log("Properties file(s) loaded. Starting with execution of the process.");
			DBConnectionInit.getInstance(propertyLoader);
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
		} catch (InterruptedException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} catch (ExecutionException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} catch (DBException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} catch (ClassNotFoundException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
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
				propertyLoader.load(tempList);
			} else {
				tempList.add(getPropertyLoadDetails());
				propertyLoader.load(tempList);
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

	protected ArrayList<PropertyLoaderDetails> getALlMainPropertyFiles() {
		ArrayList<PropertyLoaderDetails> tempList = new ArrayList<PropertyLoaderDetails>();
		tempList.add(new PropertyLoaderDetails("batchMain.properties", false));
		tempList.add(new PropertyLoaderDetails("db.properties", false));
		tempList.add(new PropertyLoaderDetails("messages.properties", false));
		return tempList;
	}

	public boolean loadMainPropertyFile() {
		return true;
	}

	public abstract void execute();

	public abstract PropertyLoaderDetails getPropertyLoadDetails();

	public abstract List<PropertyLoaderDetails> getPropertyLoadDetailsList();

}
