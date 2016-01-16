/**
 * 
 */
package com.suggesthashtag.instaapi.httpconnection;

import java.net.URI;
import java.net.URL;

import com.suggesthashtag.instaapi.httpconnection.httpProxy.HttpProxyType;
import com.suggesthashtag.instaapi.httpconnection.httpProxy.HttpProxyTypeInterface;

/**
 * @author sumitpoddar
 *
 */
public class HttpConnectionParams {

	private URI requestUri = null;
	private HttpProxyTypeInterface httpProxyObject = null;
	private int connectionTimeout = 0;
	private int socketTimeout = 0;

	public URI getRequestUri() {
		return this.requestUri;
	}

	public void setRequestUri(URI requestUri) {
		this.requestUri = requestUri;
	}

	public HttpProxyTypeInterface getHttpProxyObject() {
		return this.httpProxyObject;
	}

	public void setHttpProxyObject(HttpProxyTypeInterface httpProxyObject) {
		this.httpProxyObject = httpProxyObject;
	}

	public int getConnectionTimeout() {
		return this.connectionTimeout;
	}

	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public int getSocketTimeout() {
		return this.socketTimeout;
	}

	public void setSocketTimeout(int socketTimeout) {
		this.socketTimeout = socketTimeout;
	}

}
