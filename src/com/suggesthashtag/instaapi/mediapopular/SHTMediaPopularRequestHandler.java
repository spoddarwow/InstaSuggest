package com.suggesthashtag.instaapi.mediapopular;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.nio.IOControl;
import org.apache.http.nio.client.methods.AsyncCharConsumer;
import org.apache.http.nio.client.methods.HttpAsyncMethods;
import org.apache.http.protocol.HttpContext;

import com.suggesthashtag.instaapi.framework.AbstractInstaApiHandler;
import com.suggesthashtag.instaapi.framework.annotation.ApiBatchAnnotaion;
import com.suggesthashtag.logger.LogManager;
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

		CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();
		try {
			httpclient.start();
			Future<Boolean> future = httpclient
					.execute(
							HttpAsyncMethods
									.createGet("https://api.instagram.com/v1/tags/hi%C3%A7/media/recent?access_token=1689077491.1fb234f.37f96a2796914dfc8c5d064c652d5821"),
							new MyResponseConsumer(), null);
			Boolean result = future.get();
			if (result != null && result.booleanValue()) {
				LogManager.log("Request successfully executed");
			} else {
				LogManager.log("Request failed");
			}
			LogManager.log("Shutting down");
		} catch (InterruptedException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} catch (ExecutionException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
		}
		LogManager.log("Done");

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

class MyResponseConsumer extends AsyncCharConsumer<Boolean> {

	@Override
	protected void onResponseReceived(final HttpResponse response) {
	}

	@Override
	protected void onCharReceived(final CharBuffer buf, final IOControl ioctrl)
			throws IOException {
		while (buf.hasRemaining()) {
			char[] chars = {buf.get()};
			LogManager.log(new String(chars) );
		}
	}

	@Override
	protected void releaseResources() {
	}

	@Override
	protected Boolean buildResult(final HttpContext context) {
		return Boolean.TRUE;
	}

}
