/**
 * 
 */
package test.com.suggesthashtag.instaapi.propertyloader.decorateProp;

import junit.framework.TestCase;

import org.junit.Test;

import com.suggesthashtag.propertyloader.decorateProp.PropertyDecoratorInterface;
import com.suggesthashtag.propertyloader.decorateProp.PropertyDecoratorListHandler;
import com.suggesthashtag.propertyloader.decorateProp.PropertyListHolder;
import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author sumitpoddar
 *
 */
public class TestPropertyDecoratorListHandler extends TestCase {

	@Test
	public void testBasic() throws PropertyException {
		PropertyDecoratorInterface interfaceObject = new PropertyDecoratorListHandler();
		PropertyListHolder expectedObject = new PropertyListHolder(
				String.class, "sadsd asd,sdaasdad");
		PropertyListHolder actualObject = interfaceObject
				.decorateProperty("List<String>[sadsd asd,sdaasdad]");
		assertEquals(expectedObject.getListTypeClass(),
				actualObject.getListTypeClass());
		assertEquals(expectedObject.getValues(), actualObject.getValues());
	}

	@Test(expected = PropertyException.class)
	public void testBasic1() throws PropertyException {
		PropertyDecoratorInterface interfaceObject = new PropertyDecoratorListHandler();
		interfaceObject.decorateProperty("List<12312>");

	}

	@Test(expected = PropertyException.class)
	public void testBasic2() throws PropertyException {
		PropertyDecoratorInterface interfaceObject = new PropertyDecoratorListHandler();
		PropertyListHolder expectedObject = new PropertyListHolder(
				String.class, "sadsd asd,sdaasdad");
		PropertyListHolder actualObject = interfaceObject
				.decorateProperty("List<12312>]");
		assertEquals(expectedObject.getListTypeClass(),
				actualObject.getListTypeClass());
		assertEquals(expectedObject.getValues(), actualObject.getValues());
	}

	@Test(expected = PropertyException.class)
	public void testBasic3() throws PropertyException {
		PropertyDecoratorInterface interfaceObject = new PropertyDecoratorListHandler();
		PropertyListHolder expectedObject = new PropertyListHolder(
				String.class, "sadsdasd,sdaasdad");
		PropertyListHolder actualObject = interfaceObject
				.decorateProperty("List<12312>]");
		assertEquals(expectedObject.getListTypeClass(),
				actualObject.getListTypeClass());
		assertEquals(expectedObject.getValues(), actualObject.getValues());
	}
}
