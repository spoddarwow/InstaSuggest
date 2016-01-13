/**
 * 
 */
package com.suggesthashtag.instaapi.httpconnection;

import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;

/**
 * @author sumitpoddar
 *         <ul>
 *         <li>Implement the connection pools</li>
 *         </ul>
 *
 */
public class HttpConnectionPool {

	private static HttpConnectionPool MY_INSTANCE = new HttpConnectionPool();
	private CloseableHttpAsyncClient httpclient = null;

	/**
	 * Singleton constructor
	 */
	private HttpConnectionPool() {
		this.httpclient = HttpAsyncClients.createDefault();
	}

	public HttpConnectionPool getInstance() {
		return MY_INSTANCE;
	}

	public CloseableHttpAsyncClient getHttpClient() {
		return this.httpclient;
	}
}
