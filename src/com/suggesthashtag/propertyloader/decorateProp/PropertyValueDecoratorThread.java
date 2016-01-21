/**
 * 
 */
package com.suggesthashtag.propertyloader.decorateProp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.suggesthashtag.propertyloader.Property;
import com.suggesthashtag.propertyloader.PropertyLoader;
import com.suggesthashtag.propertyloader.PropertyLoaderDetails;
import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author sumitpoddar
 *
 */
public class PropertyValueDecoratorThread implements Runnable {

	private int threadIndex;
	private PropertyLoaderDetails propFileDetails;
	private Thread thisThread;
	private String threadName;
	private Property tempProperty = new Property();

	/**
	 * @param threadIndex
	 * @param propFileDetails
	 * @param threadName
	 */
	public PropertyValueDecoratorThread(int threadIndex,
			PropertyLoaderDetails propFileDetails, String threadName) {
		super();
		this.threadIndex = threadIndex;
		this.propFileDetails = propFileDetails;
		this.threadName = threadName;
		this.thisThread = new Thread(this, this.threadName);
		this.thisThread.start();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			InputStream inputStream = PropertyLoader.class.getClassLoader()
					.getResourceAsStream(propFileDetails.toString());
			if (inputStream != null) {
				tempProperty.load(inputStream);
				System.out.println(tempProperty);
			} else {
				throw new FileNotFoundException("Property file "
						+ propFileDetails.toString()
						+ " not found in the classpath");
			}
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		}

	}

	public int getThreadIndex() {
		return this.threadIndex;
	}

	public void setThreadIndex(int threadIndex) {
		this.threadIndex = threadIndex;
	}

	public PropertyLoaderDetails getPropFileDetails() {
		return this.propFileDetails;
	}

	public void setPropFileDetails(PropertyLoaderDetails propFileDetails) {
		this.propFileDetails = propFileDetails;
	}

	public String getThreadName() {
		return this.threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	public Property getTempProperty() {
		return this.tempProperty;
	}

	public void setTempProperty(Property tempProperty) {
		this.tempProperty = tempProperty;
	}

	public Thread getThisThread() {
		return this.thisThread;
	}

	public void setThisThread(Thread thisThread) {
		this.thisThread = thisThread;
	}

}
