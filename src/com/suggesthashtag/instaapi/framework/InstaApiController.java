package com.suggesthashtag.instaapi.framework;

import java.util.HashMap;

/**
 * Controller to mention the Insta API's for batch processing.
 * 
 * @author sumitpoddar
 *
 */
public class InstaApiController {

	private InstaApiController MY_INSTANCE = new InstaApiController();

	private HashMap<String, InstaApiEnum> apiIdentifierMap = new HashMap<String, InstaApiController.InstaApiEnum>();

	private InstaApiController() {
		setApiIdentifierMap();
	}

	public InstaApiController getInstance() {
		return MY_INSTANCE;
	}

	public HashMap<String, InstaApiEnum> getApiIdentifierMap() {
		return apiIdentifierMap;
	}

	private void setApiIdentifierMap() {
		HashMap<String, InstaApiEnum> apiIdentifierMapTemp = new HashMap<String, InstaApiController.InstaApiEnum>();
		for (InstaApiEnum value : InstaApiEnum.values()) {
			apiIdentifierMapTemp.put(value.getApiIdentifier(), value);
		}

		this.apiIdentifierMap = apiIdentifierMapTemp;
	}

	public enum InstaApiEnum {
		TAG_NAME_SEARCH("tagNameSearch"), POPULAR_MEDIA("popularMedia");

		private String apiIdentifier = "";

		private InstaApiEnum(String apiIdentifier) {
			this.apiIdentifier = apiIdentifier;
		}

		public String getApiIdentifier() {
			return apiIdentifier;
		}

	}
}
