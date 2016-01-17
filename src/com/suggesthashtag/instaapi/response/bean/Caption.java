/**
 * 
 */
package com.suggesthashtag.instaapi.response.bean;

/**
 * @author sumitpoddar
 *
 */
public class Caption {

	protected String text;
	protected long id;
	protected String created_time;
	protected User from;

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCreated_time() {
		return this.created_time;
	}

	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}

	public User getFrom() {
		return this.from;
	}

	public void setFrom(User from) {
		this.from = from;
	}

}
