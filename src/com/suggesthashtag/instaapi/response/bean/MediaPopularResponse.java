/**
 * 
 */
package com.suggesthashtag.instaapi.response.bean;

import java.util.List;

import com.suggesthashtag.instaapi.response.APIResponse;
import com.suggesthashtag.instaapi.response.bean.Meta;

/**
 * @author sumitpoddar
 *
 */
public class MediaPopularResponse extends APIResponse{

	protected List<MediaPopularData> data;
	protected Meta meta;

	public List<MediaPopularData> getData() {
		return this.data;
	}

	public void setData(List<MediaPopularData> data) {
		this.data = data;
	}

	public Meta getMeta() {
		return this.meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

}
