/**
 * 
 */
package com.suggesthashtag.instaapi.response.bean;

/**
 * @author sumitpoddar
 *
 */
public class User {

	protected String username;
	protected long id;
	protected String full_name;
	protected String profilePicture;

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFull_name() {
		return this.full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getProfilePicture() {
		return this.profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

}
