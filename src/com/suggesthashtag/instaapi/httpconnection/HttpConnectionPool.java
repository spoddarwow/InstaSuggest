/**
 * 
 */
package com.suggesthashtag.instaapi.httpconnection;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.impl.nio.client.HttpAsyncClients;

import com.suggesthashtag.instaapi.httpconnection.httpProxy.HttpProxyType;

/**
 * @author sumitpoddar
 *         <ul>
 *         <li>Implement the connection pools</li>
 *         </ul>
 *
 */
public class HttpConnectionPool {

	// private static HttpConnectionPool MY_INSTANCE = new HttpConnectionPool();
	private CloseableHttpAsyncClient httpclient = null;

	/**
	 * Singleton constructor
	 */
	public HttpConnectionPool() {
	}

	public CloseableHttpAsyncClient buildHttpClient(
			HttpConnectionParams httpConnectionParams) {
		RequestConfig requestConfig = buildRequestConfig(httpConnectionParams);
		CredentialsProvider credsProvider = getProxyIfWithCredentials(httpConnectionParams);
		HttpAsyncClientBuilder tempHttpClient = HttpAsyncClients.custom();
		if (requestConfig != null) {
			tempHttpClient.setDefaultRequestConfig(requestConfig);
		}

		if (credsProvider != null) {
			tempHttpClient.setDefaultCredentialsProvider(credsProvider);
		}

		this.httpclient = tempHttpClient.build();
		return this.httpclient;
	}

	/**
	 * @param httpConnectionParams
	 * @return
	 */
	private RequestConfig buildRequestConfig(
			HttpConnectionParams httpConnectionParams) {
		Builder requestBuilderConfig = RequestConfig.custom();
		setTimeOutParameters(httpConnectionParams, requestBuilderConfig);
		return requestBuilderConfig.build();
	}

	/**
	 * @param httpConnectionParams
	 * @param requestBuilderConfig
	 */
	private CredentialsProvider getProxyIfWithCredentials(
			HttpConnectionParams httpConnectionParams) {
		CredentialsProvider credsProvider = null;
		if (httpConnectionParams.getHttpProxyObject().getHttpProxyType() == HttpProxyType.PROXY_CRED) {
			credsProvider = new BasicCredentialsProvider();
			credsProvider.setCredentials(new AuthScope(httpConnectionParams
					.getHttpProxyObject().getHttpHost()),
					new UsernamePasswordCredentials(httpConnectionParams
							.getHttpProxyObject().getProxyUserName(),
							httpConnectionParams.getHttpProxyObject()
									.getProxyPassword()));
		}

		return credsProvider;

	}

	private void setTimeOutParameters(
			HttpConnectionParams httpConnectionParams,
			Builder requestBuilderConfig) {
		if (httpConnectionParams.getSocketTimeout() != 0) {
			requestBuilderConfig.setSocketTimeout(httpConnectionParams
					.getSocketTimeout());
		}
		if (httpConnectionParams.getConnectionTimeout() != 0) {
			requestBuilderConfig.setConnectTimeout(httpConnectionParams
					.getConnectionTimeout());
		}
	}
}
