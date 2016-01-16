/**
 * 
 */
package com.suggesthashtag.instaapi.httpconnection;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.http.HttpException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.nio.client.methods.HttpAsyncMethods;
import org.apache.http.nio.protocol.HttpAsyncRequestProducer;

import com.suggesthashtag.instaapi.beans.HttpResultBean;
import com.suggesthashtag.instaapi.httpconnection.httpProxy.HttpProxyType;

/**
 * @author sumitpoddar
 *
 */
public class HTTPConnectionUtil {

	private static HTTPConnectionUtil MY_INSANCE = new HTTPConnectionUtil();

	private HTTPConnectionUtil() {

	}

	public static HTTPConnectionUtil getInstance() {
		return MY_INSANCE;
	}

	public HttpResultBean getHttpGetResponse(
			HttpConnectionParams httpConnectionParams)
			throws HttpConnectionException, IOException, HttpException,
			InterruptedException, ExecutionException {

		return getHttpMainResponse(
				httpConnectionParams,
				HttpAsyncMethods.createGet(httpConnectionParams.getRequestUri()));
	}

	public HttpResultBean getHttpPostResponse(
			HttpConnectionParams httpConnectionParams)
			throws HttpConnectionException {
		return null;
	}

	private HttpResultBean getHttpMainResponse(
			HttpConnectionParams httpConnectionParams,
			HttpAsyncRequestProducer httpAsncRequestBase)
			throws HttpConnectionException, IOException, HttpException {
		RequestConfig requestConfig = null;
		if (httpConnectionParams == null) {
			throw new HttpConnectionException(
					"Params for the HTTP Connection cannot be null.");
		}

		CloseableHttpAsyncClient connectionPool = new HttpConnectionPool()
				.buildHttpClient(httpConnectionParams);

		if (httpConnectionParams.getHttpProxyObject().getHttpProxyType() == HttpProxyType.PROXY_BASIC) {
			requestConfig = RequestConfig
					.custom()
					.setProxy(
							httpConnectionParams.getHttpProxyObject()
									.getHttpHost()).build();
			((HttpRequestBase) httpAsncRequestBase.generateRequest())
					.setConfig(requestConfig);

		}
		HttpResultBean resultBean = null;
		try {
			connectionPool.start();
			Future<HttpResultBean> future = connectionPool.execute(
					httpAsncRequestBase, new HttpConnectionResponseConsumer(),
					null);
			resultBean = future.get();
		} catch (InterruptedException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} catch (ExecutionException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} finally {
			connectionPool.close();
		}
		return resultBean;

	}
}
