/**
 * 
 */
package com.suggesthashtag.instaapi.framework;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import com.google.gson.Gson;
import com.suggesthashtag.instaapi.framework.exception.SHTMainException;
import com.suggesthashtag.instaapi.httpconnection.HttpConnectionParams;
import com.suggesthashtag.instaapi.httpconnection.httpProxy.HttpProxyBasicImpl;
import com.suggesthashtag.instaapi.httpconnection.httpProxy.HttpProxyBasicWithCredentialImpl;
import com.suggesthashtag.instaapi.httpconnection.httpProxy.HttpProxyNoImpl;
import com.suggesthashtag.instaapi.httpconnection.httpProxy.HttpProxyType;
import com.suggesthashtag.instaapi.httpconnection.httpProxy.HttpProxyTypeInterface;
import com.suggesthashtag.instaapi.response.APIResponse;
import com.suggesthashtag.propertyloader.PropertyLoader;
import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author sumitpoddar
 *
 */
public class SHTBatchUtil {

	private static SHTBatchUtil MY_INSTANCE = new SHTBatchUtil();

	private SHTBatchUtil() {

	}

	public static SHTBatchUtil getInstance() {
		return MY_INSTANCE;
	}

	public HttpConnectionParams buildHttpParam(PropertyLoader propertyLoader)
			throws PropertyException, MalformedURLException, URISyntaxException {
		HttpConnectionParams httpParams = new HttpConnectionParams();
		if (propertyLoader == null) {
			throw new PropertyException(
					"Property Loader cannot be null to build HTTP Params.");
		}

		httpParams.setRequestUri(new URI(propertyLoader.getString(
				"instaapi.url", "")));
		httpParams.setConnectionTimeout(propertyLoader.getInteger(
				"api.connec_timeout", "0"));
		httpParams.setSocketTimeout(propertyLoader.getInteger(
				"api.socket_timeout", "0"));
		HttpProxyTypeInterface proxyTypeInterface = null;
		if (!"".equals(propertyLoader.getString("proxy.type", ""))) {
			HttpProxyType proxyType = HttpProxyType.valueOf(propertyLoader
					.getString("proxy.type", ""));
			if (proxyType != null) {
				switch (proxyType) {
				case PROXY_NO:
					proxyTypeInterface = new HttpProxyNoImpl();
					break;
				case PROXY_BASIC:
					proxyTypeInterface = new HttpProxyBasicImpl(
							propertyLoader.getString("proxy.host", ""),
							propertyLoader.getInteger("proxy.port", "0"));
					break;
				case PROXY_CRED:
					proxyTypeInterface = new HttpProxyBasicWithCredentialImpl(
							propertyLoader.getString("proxy.host", ""),
							propertyLoader.getInteger("proxy.port", "0"),
							propertyLoader.getString("proxy.username", ""),
							propertyLoader.getString("proxy.password", ""));
					break;
				default:
					proxyTypeInterface = new HttpProxyNoImpl();
					break;
				}
				httpParams.setHttpProxyObject(proxyTypeInterface);
			}
		}
		return httpParams;
	}

	public Object convertJsonToObject(String jsonObject,
			Class<? extends APIResponse> wrapperClass) {
		if (jsonObject == null || "".equals(jsonObject) || wrapperClass == null) {
			return null;
		}
		Gson gson = new Gson();
		return gson.fromJson(jsonObject, wrapperClass);

	}
}
