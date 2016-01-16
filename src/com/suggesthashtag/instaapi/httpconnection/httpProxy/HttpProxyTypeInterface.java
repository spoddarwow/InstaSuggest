/**
 * 
 */
package com.suggesthashtag.instaapi.httpconnection.httpProxy;

import org.apache.http.HttpHost;

/**
 * @author sumitpoddar
 *
 */
public interface HttpProxyTypeInterface {

	boolean isProxyEnabled();

	HttpHost getHttpHost();

	String getProxyUserName();

	String getProxyPassword();

	HttpProxyType getHttpProxyType();
}
