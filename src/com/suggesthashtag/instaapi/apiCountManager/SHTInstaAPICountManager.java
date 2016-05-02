/**
 * 
 */
package com.suggesthashtag.instaapi.apiCountManager;

import java.util.List;

import com.suggesthashtag.instaapi.framework.AbstractSHTBatchHandler;
import com.suggesthashtag.propertyloader.PropertyLoaderDetails;

/**
 * @author sumitpoddar
 *
 */
public class SHTInstaAPICountManager extends AbstractSHTBatchHandler {

	private final static String thisBatchName = "SHTInstaAPICountManager";

	/**
	 * @param batchName
	 */
	public SHTInstaAPICountManager(String batchName) {
		super(batchName);
	}

	public static void main(String[] args) {
		new SHTInstaAPICountManager(thisBatchName).process(
				SHTInstaAPICountManager.class, args);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.suggesthashtag.instaapi.framework.AbstractSHTBatchHandler#execute()
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		log("Executing the SHTInstaAPICountManager.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.suggesthashtag.instaapi.framework.AbstractSHTBatchHandler#
	 * getPropertyLoadDetails()
	 */
	@Override
	public PropertyLoaderDetails getPropertyLoadDetails() {
		return new PropertyLoaderDetails("instaApiCountManager.properties");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.suggesthashtag.instaapi.framework.AbstractSHTBatchHandler#
	 * getPropertyLoadDetailsList()
	 */
	@Override
	public List<PropertyLoaderDetails> getPropertyLoadDetailsList() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.suggesthashtag.logger.LogManager#getLoggerName()
	 */
	@Override
	public String getLoggerName() {
		return thisBatchName;
	}

}
