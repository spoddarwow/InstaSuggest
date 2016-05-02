/**
 * 
 */
package com.suggesthashtag.instaapi.mediapopular;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;

/**
 * @author xspro
 *
 */
public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "{strings :[\"hello\",\"bye\"]}";
		Gson gson = new Gson();
		SHTStringArray strArray = gson.fromJson(input, SHTStringArray.class);
		for (String str : strArray.getStrings()) {
			System.out.println(str);
		}

		input = "{integers :[\"100\",\"13\"]}";

		gson = new Gson();
		SHTIntegerArray intArray = gson.fromJson(input, SHTIntegerArray.class);
		for (int str : intArray.getIntegers()) {
			System.out.println(str);
		}

		String pattern = "Object<([a-zA-Z]+)>\\[\\{(.*)\\}\\]$";
		String value = "Object<hghf>[{strings :[\"hello\",\"bye\"]}]";
		Pattern pat = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pat.matcher(value);
		if (matcher.matches()) {
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
		}
	}
}

class SHTStringArray {

	List<String> strings = new ArrayList<String>();

	public List<String> getStrings() {
		return this.strings;
	}

	public void setStrings(List<String> strings) {
		this.strings = strings;
	}

}

class SHTIntegerArray {

	List<Integer> integers = new ArrayList<Integer>();

	public List<Integer> getIntegers() {
		return this.integers;
	}

	public void setIntegers(List<Integer> integers) {
		this.integers = integers;
	}

}