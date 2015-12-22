package com.suggesthashtag.instaapi.framework.annotation;

/**
 * 
 * Annotation to mention the required command line argument for the Insta API.
 * 
 * @author sumitpoddar
 *
 */
public @interface ApiBatchAnnotaion {

	String[] requiredCommandLineArgs();
}
