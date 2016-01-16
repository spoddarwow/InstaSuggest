/**
 * 
 */
package com.suggesthashtag.instaapi.httpconnection;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.nio.client.methods.HttpAsyncMethods;
import org.apache.http.nio.protocol.HttpAsyncRequestProducer;
import org.apache.http.util.EntityUtils;

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

	public String getHttpGetResponse(HttpConnectionParams httpConnectionParams)
			throws HttpConnectionException, IOException, HttpException,
			InterruptedException, ExecutionException {

		return getHttpMainResponse(httpConnectionParams, new HttpGet(
				httpConnectionParams.getRequestUri()));
	}

	public String getHttpPostResponse(HttpConnectionParams httpConnectionParams)
			throws HttpConnectionException, IOException, HttpException {
		return getHttpMainResponse(httpConnectionParams, new HttpPost(
				httpConnectionParams.getRequestUri()));
	}

	private String getHttpMainResponse(
			HttpConnectionParams httpConnectionParams,
			HttpRequestBase httpRequestBase) throws HttpConnectionException,
			IOException, HttpException {
		String apiResponse = "";
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
			httpRequestBase.setConfig(requestConfig);

		}
		HttpResponse resultBean = null;
		try {
			connectionPool.start();
			Future<HttpResponse> future = connectionPool.execute(
					httpRequestBase, null);
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

		if (resultBean != null) {
			HttpEntity entity = resultBean.getEntity();
			if (entity != null) {
				apiResponse = EntityUtils.toString(entity, "UTF8");
			}

		}

		return apiResponse;

	}
}
