/**
 * 
 */
package com.suggesthashtag.instaapi.response.bean;

import java.util.List;

/**
 * @author sumitpoddar
 *
 */
public class MediaPopularData {

	protected Attribution attribution = null;
	protected Caption caption = null;
	protected Comments comments = null;
	protected int created_time = 0;
	protected String filter = null;
	protected String id = null;
	protected Media images = null;
	protected Media videos = null;
	protected Likes likes = null;
	protected String link = null;
	protected Location location = null;
	protected List<String> tags = null;
	protected String type = null;
	protected User user = null;
	protected String user_has_liked = null;
	protected List<UsersInPhoto> users_in_photo = null;

	public Attribution getAttribution() {
		return this.attribution;
	}

	public void setAttribution(Attribution attribution) {
		this.attribution = attribution;
	}

	public Caption getCaption() {
		return this.caption;
	}

	public void setCaption(Caption caption) {
		this.caption = caption;
	}

	public Comments getComments() {
		return this.comments;
	}

	public void setComments(Comments comments) {
		this.comments = comments;
	}

	public String getFilter() {
		return this.filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Media getImages() {
		return this.images;
	}

	public void setImages(Media images) {
		this.images = images;
	}

	public Media getVideos() {
		return this.videos;
	}

	public void setVideos(Media videos) {
		this.videos = videos;
	}

	public Likes getLikes() {
		return this.likes;
	}

	public void setLikes(Likes likes) {
		this.likes = likes;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<String> getTags() {
		return this.tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getCreated_time() {
		return this.created_time;
	}

	public void setCreated_time(int created_time) {
		this.created_time = created_time;
	}

	public String getUser_has_liked() {
		return this.user_has_liked;
	}

	public void setUser_has_liked(String user_has_liked) {
		this.user_has_liked = user_has_liked;
	}

	public List<UsersInPhoto> getUsers_in_photo() {
		return this.users_in_photo;
	}

	public void setUsers_in_photo(List<UsersInPhoto> users_in_photo) {
		this.users_in_photo = users_in_photo;
	}

}
