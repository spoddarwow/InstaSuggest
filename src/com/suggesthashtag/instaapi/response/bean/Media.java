/**
 * 
 */
package com.suggesthashtag.instaapi.response.bean;

/**
 * @author sumitpoddar
 *
 */
public class Media {

	protected MediaAttributes low_resolution;
	protected MediaAttributes standard_resolution;
	protected MediaAttributes thumbnail;
	protected MediaAttributes low_bandwidth;

	public MediaAttributes getLow_resolution() {
		return this.low_resolution;
	}

	public void setLow_resolution(MediaAttributes low_resolution) {
		this.low_resolution = low_resolution;
	}

	public MediaAttributes getStandard_resolution() {
		return this.standard_resolution;
	}

	public void setStandard_resolution(MediaAttributes standard_resolution) {
		this.standard_resolution = standard_resolution;
	}

	public MediaAttributes getThumbnail() {
		return this.thumbnail;
	}

	public void setThumbnail(MediaAttributes thumbnail) {
		this.thumbnail = thumbnail;
	}

	public MediaAttributes getLow_bandwidth() {
		return this.low_bandwidth;
	}

	public void setLow_bandwidth(MediaAttributes low_bandwidth) {
		this.low_bandwidth = low_bandwidth;
	}

}
