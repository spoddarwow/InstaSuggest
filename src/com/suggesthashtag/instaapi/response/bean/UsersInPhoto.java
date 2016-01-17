/**
 * 
 */
package com.suggesthashtag.instaapi.response.bean;


/**
 * @author sumitpoddar
 *
 */
public class UsersInPhoto {
	protected Position position;
	protected User user;

	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
