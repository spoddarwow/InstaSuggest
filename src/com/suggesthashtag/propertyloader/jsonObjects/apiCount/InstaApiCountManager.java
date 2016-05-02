/**
 * 
 */
package com.suggesthashtag.propertyloader.jsonObjects.apiCount;

import java.util.ArrayList;
import java.util.List;

import com.suggesthashtag.propertyloader.datatype.PropertyObjects;

/**
 * @author sumitpoddar
 *
 */
public class InstaApiCountManager extends PropertyObjects {

	private int totalApiCount;
	private List<InstaApiDetails> apis = new ArrayList<InstaApiDetails>();

	public int getTotalIGApiLimit() {
		return this.totalApiCount;
	}

	public void setTotalIGApiLimit(int totalApiCount) {
		this.totalApiCount = totalApiCount;
	}

	public List<InstaApiDetails> getApis() {
		return this.apis;
	}

	public void setApis(List<InstaApiDetails> apis) {
		this.apis = apis;
	}

}
