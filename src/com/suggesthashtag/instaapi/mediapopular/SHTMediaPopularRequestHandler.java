package com.suggesthashtag.instaapi.mediapopular;

import com.suggesthashtag.instaapi.framework.AbstractInstaApiHandler;
import com.suggesthashtag.instaapi.framework.annotation.ApiBatchAnnotaion;

@ApiBatchAnnotaion(requiredCommandLineArgs = { "environment" })
public class SHTMediaPopularRequestHandler extends AbstractInstaApiHandler {

	
	public static void main(String[] args) {
		process(SHTMediaPopularRequestHandler.class, args);
	}

	@Override
	public String getLoggerFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLoggerFilePath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPropsFileName() {
		return "media_popular_";
	}

	@Override
	public String getPropsFilePath() {
		return "";
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.suggesthashtag.instaapi.framework.AbstractInstaApiHandler#execute()
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
