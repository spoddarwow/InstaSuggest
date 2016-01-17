package com.suggesthashtag.instaapi.mediapopular;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpException;

import com.suggesthashtag.instaapi.framework.AbstractSHTBatchHandler;
import com.suggesthashtag.instaapi.framework.SHTBatchUtil;
import com.suggesthashtag.instaapi.framework.annotation.ApiBatchAnnotaion;
import com.suggesthashtag.instaapi.httpconnection.HTTPConnectionUtil;
import com.suggesthashtag.instaapi.httpconnection.HttpConnectionException;
import com.suggesthashtag.instaapi.httpconnection.HttpConnectionParams;
import com.suggesthashtag.instaapi.response.bean.MediaPopularResponse;
import com.suggesthashtag.propertyloader.PropertyLoaderDetails;
import com.suggesthashtag.propertyloader.exception.PropertyException;

@ApiBatchAnnotaion(requiredCommandLineArgs = { "environment" })
public class SHTMediaPopularRequestHandler extends AbstractSHTBatchHandler {

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
		// Hit the instagram api.
		try {
			log("Executing the SHTMediaPopularRequestHandler.");
			HttpConnectionParams httpConnectionParams = SHTBatchUtil
					.getInstance().buildHttpParam(super.propertyLoader);
			String resultJson = HTTPConnectionUtil.getInstance()
					.getHttpGetResponse(httpConnectionParams);
			MediaPopularResponse responseObject = (MediaPopularResponse) SHTBatchUtil
					.getInstance().convertJsonToObject(resultJson,
							MediaPopularResponse.class);
			log("Execution over for the SHTMediaPopularRequestHandler. : "
					+ resultJson);
		} catch (MalformedURLException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} catch (PropertyException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} catch (URISyntaxException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} catch (HttpConnectionException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} catch (IOException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} catch (HttpException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} catch (InterruptedException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} catch (ExecutionException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}
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
