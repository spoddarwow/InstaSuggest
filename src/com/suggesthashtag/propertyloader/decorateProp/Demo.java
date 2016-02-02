/**
 * 
 */
package com.suggesthashtag.propertyloader.decorateProp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 * @author sumitpoddar
 *
 */
public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		///
		String value = "${instaapi.utl_header}/v1/media/popular?access_token=\\${instaapi.access_token}";
		Pattern pattern = Pattern.compile("\\$\\{(.*)\\}?(.*)");
		Matcher matcher = pattern.matcher(value);
		if (matcher.matches()) {

			for (int i = 0; i < matcher.groupCount(); i++) {
				System.out.println(matcher.group(i));
			}
		}
	}

	public static void process() {
		// List<(\\S+)> | List<String>
		// \\[(\\S+,?)[^,$]\\]
		String value = "[\"12\" \"12\"]";
		Pattern pattern = Pattern.compile("\\[[^\"(.*)\"$]\\]$");
		System.out.println("Starting : " + value);
		Matcher matcher = pattern.matcher(value);
		if (matcher.matches()) {
			System.out.println(matcher.group(1));
		}
		System.out.println("Ended");
	}
}
