/**
 * 
 */
package com.suggesthashtag.propertyloader.decorateProp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sumitpoddar
 *
 */
public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List<(\\S+)> | List<String>
		//\\[(\\S+,?)[^,$]\\]
		String value = "List<<>()67jksad>[";
		Pattern pattern = Pattern.compile("List<([a-zA-Z]+)>\\[(.*)\\]$");
		System.out.println("Starting : "+value);
		Matcher matcher = pattern.matcher(value);
		if (matcher.matches()) {
			System.out.println(matcher.group(1));
		}
		System.out.println("Ended");
	}

}
