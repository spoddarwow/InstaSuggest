/**
 * 
 */
package com.suggesthashtag.instaapi.httpconnection.httpProxy;

/**
 * @author sumitpoddar
 *
 */
public class HttpProxyBasicWithCredentialImpl extends HttpProxyBasicImpl {

	private final HttpProxyType httpProxyType = HttpProxyType.PROXY_CRED;
	private String proxyUserName = "";
	private String proxyPassword = "";

	/**
	 * @param hostName
	 * @param portNumber
	 */
	public HttpProxyBasicWithCredentialImpl(String hostName, int portNumber,
			String proxyUserName, String proxyPassword) {
		super(hostName, portNumber);
		setProxyUserName(proxyUserName);
		setProxyPassword(proxyPassword);
	}

	public String getProxyUserName() {
		return this.proxyUserName;
	}

	public void setProxyUserName(String proxyUserName) {
		this.proxyUserName = proxyUserName;
	}

	public String getProxyPassword() {
		return this.proxyPassword;
	}

	public void setProxyPassword(String proxyPassword) {
		this.proxyPassword = proxyPassword;
	}

}
