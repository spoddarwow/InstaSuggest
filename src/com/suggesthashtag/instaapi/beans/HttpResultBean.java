/**
 * 
 */
package com.suggesthashtag.instaapi.beans;

import org.apache.http.HttpResponse;

/**
 * @author sumitpoddar
 *
 */
public class HttpResultBean {

	private HttpResponse httpResponse = null;
	private String response = "";

	/**
	 * 
	 */
	public HttpResultBean(HttpResponse httpResponse, String response) {
		// TODO Auto-generated constructor stub
		this.httpResponse = httpResponse;
		this.response = response;
	}

	public HttpResponse getHttpResponse() {
		return this.httpResponse;
	}

	public void setHttpResponse(HttpResponse httpResponse) {
		this.httpResponse = httpResponse;
	}

	public String getResponse() {
		return this.response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

}
