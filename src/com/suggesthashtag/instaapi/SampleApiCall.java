package com.suggesthashtag.instaapi;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.nio.IOControl;
import org.apache.http.nio.client.methods.AsyncCharConsumer;
import org.apache.http.nio.client.methods.HttpAsyncMethods;
import org.apache.http.protocol.HttpContext;

import com.suggesthashtag.instaapi.beans.HttpResultBean;

public class SampleApiCall {
	static StringBuffer response = new StringBuffer();

	public static void main(final String[] args) throws Exception {
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(3000).setConnectTimeout(3000).build();
		CloseableHttpAsyncClient httpclient = HttpAsyncClients.custom()
				.setDefaultRequestConfig(requestConfig).build();
		try {
			httpclient.start();
			String bug = "";
			HttpPost httpGet = new HttpPost(
					"https://api.instagram.com/v1/tags/hi%C3%A7/media/recent?access_token=1689077491.1fb234f.37f96a2796914dfc8c5d064c652d5821");
			Future<HttpResponse> future = httpclient.execute(httpGet, null);
			HttpResponse result = future.get();
			if (result != null) {
				System.out.println("Request successfully executed");

				//System.out.println(result.getHttpResponse());

				//System.out.println(result.getResponse());
			} else {
				System.out.println("Request failed");
			}
			System.out.println("Shutting down");
		} finally {
			httpclient.close();
		}
		System.out.println("Done : " + response);
	}

	static class MyResponseConsumer extends AsyncCharConsumer<HttpResultBean> {

		private static HttpResponse httpResponse;
		private static StringBuffer result = new StringBuffer();

		@Override
		protected void onResponseReceived(final HttpResponse response) {
			httpResponse = response;
		}

		@Override
		protected void onCharReceived(final CharBuffer buf,
				final IOControl ioctrl) throws IOException {
			result.append(buf.toString());

		}

		@Override
		protected void releaseResources() {
		}

		@Override
		protected HttpResultBean buildResult(final HttpContext context) {
			return new HttpResultBean(httpResponse, result.toString());
		}

	}
}
