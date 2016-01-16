/**
 * 
 */
package com.suggesthashtag.instaapi.httpconnection.httpProxy;

import org.apache.http.HttpHost;

/**
 * @author sumitpoddar
 *
 */
public class HttpProxyBasicImpl implements HttpProxyTypeInterface {

	private final boolean isProxyEnabled = true;
	private final HttpProxyType httpProxyType = HttpProxyType.PROXY_BASIC;
	private HttpHost httpHost = null;

	public HttpProxyBasicImpl(String hostName, int portNumber) {
		setHttpHost(new HttpHost(hostName, portNumber));
	}

	public HttpHost getHttpHost() {
		return this.httpHost;
	}

	public void setHttpHost(HttpHost httpHost) {
		this.httpHost = httpHost;
	}

	public boolean isProxyEnabled() {
		return this.isProxyEnabled;
	}

	public HttpProxyType getHttpProxyType() {
		return this.httpProxyType;
	}

	/* (non-Javadoc)
	 * @see com.suggesthashtag.instaapi.httpconnection.httpProxy.HttpProxyTypeInterface#getProxyUserName()
	 */
	@Override
	public String getProxyUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.suggesthashtag.instaapi.httpconnection.httpProxy.HttpProxyTypeInterface#getProxyPassword()
	 */
	@Override
	public String getProxyPassword() {
		// TODO Auto-generated method stub
		return null;
	}

}
