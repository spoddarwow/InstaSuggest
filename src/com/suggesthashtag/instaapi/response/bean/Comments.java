/**
 * 
 */
package com.suggesthashtag.instaapi.response.bean;

import java.util.List;

/**
 * @author sumitpoddar
 *
 */
public class Comments {

	protected int count;
	protected List<Caption> data;

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Caption> getData() {
		return this.data;
	}

	public void setData(List<Caption> data) {
		this.data = data;
	}

}
