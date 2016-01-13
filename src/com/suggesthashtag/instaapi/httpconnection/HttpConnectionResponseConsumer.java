/**
 * 
 */
package com.suggesthashtag.instaapi.httpconnection;

import java.io.IOException;
import java.nio.CharBuffer;

import org.apache.http.HttpResponse;
import org.apache.http.nio.IOControl;
import org.apache.http.nio.client.methods.AsyncCharConsumer;
import org.apache.http.protocol.HttpContext;

import com.suggesthashtag.instaapi.beans.HttpResultBean;

/**
 * @author sumitpoddar
 *
 */
public class HttpConnectionResponseConsumer extends
		AsyncCharConsumer<HttpResultBean> {

	private static HttpResponse httpResponse;
	private static StringBuffer response = new StringBuffer();

	@Override
	protected void onResponseReceived(final HttpResponse response) {
		httpResponse = response;
	}

	@Override
	protected void onCharReceived(final CharBuffer buf, final IOControl ioctrl)
			throws IOException {
		response.append(buf.toString());

	}

	@Override
	protected void releaseResources() {
	}

	@Override
	protected HttpResultBean buildResult(final HttpContext context) {
		return new HttpResultBean(httpResponse, response.toString());
	}

}
