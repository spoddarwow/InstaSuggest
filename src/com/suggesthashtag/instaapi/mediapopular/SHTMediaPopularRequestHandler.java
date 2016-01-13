package com.suggesthashtag.instaapi.mediapopular;

import java.util.List;

import com.suggesthashtag.instaapi.framework.AbstractInstaApiHandler;
import com.suggesthashtag.instaapi.framework.annotation.ApiBatchAnnotaion;
import com.suggesthashtag.propertyloader.PropertyLoaderDetails;

@ApiBatchAnnotaion(requiredCommandLineArgs = { "environment" })
public class SHTMediaPopularRequestHandler extends AbstractInstaApiHandler {

	/**
	 * @param batchName
	 */
	public SHTMediaPopularRequestHandler(String batchName) {
		super(batchName);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		new SHTMediaPopularRequestHandler("SHTMediaPopularRequestHandler")
				.process(SHTMediaPopularRequestHandler.class, args);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.suggesthashtag.instaapi.framework.AbstractInstaApiHandler#execute()
	 */
	@Override
	public void execute() {
		log("Executing the SHTMediaPopularRequestHandler.");
		// Hit the instagram api.
		
		// Store in DB.
		log("Execution over for the SHTMediaPopularRequestHandler.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.suggesthashtag.instaapi.framework.AbstractInstaApiHandler#
	 * loadMainPropertyFile()
	 */
	@Override
	public boolean loadMainPropertyFile() {
		// TODO Auto-generated method stub
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.suggesthashtag.instaapi.framework.AbstractInstaApiHandler#
	 * getPropertyLoadDetails()
	 */
	@Override
	public PropertyLoaderDetails getPropertyLoadDetails() {
		return new PropertyLoaderDetails("mediaPopular.properties", true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.suggesthashtag.instaapi.framework.AbstractInstaApiHandler#
	 * getPropertyLoadDetailsList()
	 */
	@Override
	public List<PropertyLoaderDetails> getPropertyLoadDetailsList() {
		// TODO Auto-generated method stub
		return null;
	}

}
