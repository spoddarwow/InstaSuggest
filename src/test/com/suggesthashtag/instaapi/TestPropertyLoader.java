/**
 * 
 */
package test.com.suggesthashtag.instaapi;

import java.io.IOException;

import org.junit.Test;

import com.suggesthashtag.propertyloader.PropertyLoader;
import com.suggesthashtag.propertyloader.PropertyLoaderDetails;

import junit.framework.TestCase;

/**
 * @author sumitpoddar
 *
 */
public class TestPropertyLoader extends TestCase {
	
	@Test
	public static void testJunitClass() throws IOException{
		PropertyLoaderDetails propDetails = new PropertyLoaderDetails("demo.properties", null);
		PropertyLoader loader = new PropertyLoader();
		loader.load(propDetails);
		assertEquals("beta", loader.getString("alpha"));
		assertEquals("/alpha/${alpha}", loader.getString("newUrl"));
	}

}
