/**
 * 
 */
package com.suggesthashtag.instaapi.response.bean;


/**
 * @author sumitpoddar
 *
 */
public class Location {
	
	protected double latitude;
	protected double longitude;
	protected int id;
	protected String name;
	public double getLatitude() {
		return this.latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return this.longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
