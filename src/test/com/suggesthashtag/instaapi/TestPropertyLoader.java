/**
 * 
 */
package test.com.suggesthashtag.instaapi;

import java.io.IOException;

import org.junit.Test;

import com.suggesthashtag.propertyloader.PropertyLoader;
import com.suggesthashtag.propertyloader.PropertyLoaderDetails;
import com.suggesthashtag.propertyloader.exception.PropertyException;

import junit.framework.TestCase;

/**
 * @author sumitpoddar
 *
 */
public class TestPropertyLoader extends TestCase {

	@Test
	public static void testJunitClass() throws IOException {
		PropertyLoaderDetails propDetails = new PropertyLoaderDetails(
				"demo.properties", null);
		PropertyLoader loader = new PropertyLoader();
		loader.load(propDetails);
		try {
			assertEquals("beta", loader.getString("alpha"));
			//assertEquals(true, loader.getBoolean("int1"));
			assertEquals("/alpha/beta", loader.getInteger("url"));
			assertEquals("/danmurphys//helloworld", loader.getString("newurl"));
			assertEquals("/alpha/beta", loader.getString("url"));
		} catch (PropertyException exception) {
			// TODO Auto-generated catch block
			System.out.println("Hello");
			exception.printStackTrace();
		}
	}
}
