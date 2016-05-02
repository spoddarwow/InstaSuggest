/**
 * 
 */
package com.suggesthashtag;

import com.suggesthashtag.propertyloader.PropertyLoaderDetails;

/**
 * @author sumitpoddar
 *
 */
public class DemoClassLoader {

	public static void main(String[] args) throws ClassNotFoundException {
		PropertyLoaderDetails demoObject = new PropertyLoaderDetails(
				"asdadsda", "universal");
		System.out.println(demoObject.toString());
		demoObject = new PropertyLoaderDetails("asdadsda", "/universal");
		System.out.println(demoObject.toString());
		demoObject = new PropertyLoaderDetails("/asdadsda", "universal");
		System.out.println(demoObject.toString());
		demoObject = new PropertyLoaderDetails("/asdadsda", "/universal/");
		System.out.println(demoObject.toString());
		demoObject = new PropertyLoaderDetails("asdadsda", "//universal");
		System.out.println(demoObject.toString());

	}
}
