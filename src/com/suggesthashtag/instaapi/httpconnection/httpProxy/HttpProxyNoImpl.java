/**
 * 
 */
package com.suggesthashtag.instaapi.httpconnection.httpProxy;

import org.apache.http.HttpHost;

/**
 * @author sumitpoddar
 *
 */
public class HttpProxyNoImpl implements HttpProxyTypeInterface {

	private final boolean isProxyEnabled = false;
	private final HttpProxyType httpProxyType = HttpProxyType.PROXY_NO;

	public boolean isProxyEnabled() {
		return this.isProxyEnabled;
	}

	public HttpProxyType getHttpProxyType() {
		return this.httpProxyType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.suggesthashtag.instaapi.httpconnection.httpProxy.HttpProxyTypeInterface
	 * #getHttpHost()
	 */
	@Override
	public HttpHost getHttpHost() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.suggesthashtag.instaapi.httpconnection.httpProxy.HttpProxyTypeInterface
	 * #getProxyUserName()
	 */
	@Override
	public String getProxyUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.suggesthashtag.instaapi.httpconnection.httpProxy.HttpProxyTypeInterface
	 * #getProxyPassword()
	 */
	@Override
	public String getProxyPassword() {
		// TODO Auto-generated method stub
		return null;
	}

}
