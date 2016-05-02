/**
 * 
 */
package com.suggesthashtag.propertyloader.jsonObjects.apiCount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author sumitpoddar
 *
 */
public class DemoJsonConversion {

	public static void main(String[] args) {
		String everything = "";
		try (BufferedReader br = new BufferedReader(new FileReader(new File(
				"config/testfiles/formatJson.json")))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line.trim());
				// sb.append(System.lineSeparator());
				line = br.readLine();
			}
			everything = sb.toString();
		} catch (IOException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}
		System.out.println(everything);

	}
}
