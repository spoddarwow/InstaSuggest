/**
 * 
 */
package com.suggesthashtag.instaapi.framework;

import com.suggesthashtag.propertyloader.PropertyLoader;

/**
 * @author sumitpoddar
 *
 */
public class MainObjectHolder {

	private static PropertyLoader propertyLoader = null;

	public static PropertyLoader getPropertyLoader() {
		return propertyLoader;
	}

	public static void setPropertyLoader(PropertyLoader propertyLoader) {
		MainObjectHolder.propertyLoader = propertyLoader;
	}

}
