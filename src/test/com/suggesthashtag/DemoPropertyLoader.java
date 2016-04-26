/**
 * 
 */
package test.com.suggesthashtag;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.suggesthashtag.propertyloader.PropertyLoader;
import com.suggesthashtag.propertyloader.PropertyLoaderDetails;
import com.suggesthashtag.propertyloader.exception.PropertyException;

/**
 * @author sumitpoddar
 *
 */
public class DemoPropertyLoader {

	/**
	 * @param args
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws PropertyException
	 */
	public static void main(String[] args) throws PropertyException,
			InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		PropertyLoader propertyLoader = new PropertyLoader();
		ArrayList<PropertyLoaderDetails> tempList = new ArrayList<PropertyLoaderDetails>();
		tempList.add(new PropertyLoaderDetails("batchMain.properties", false));
		tempList.add(new PropertyLoaderDetails("db.properties", false));
		// tempList.add(new PropertyLoaderDetails("messages.properties",
		// false));
		propertyLoader.load(tempList);
		List<String> listValues = propertyLoader.getList("db.package_add");
		for (String a : listValues) {
			System.out.println(a);
		}

	}

}
