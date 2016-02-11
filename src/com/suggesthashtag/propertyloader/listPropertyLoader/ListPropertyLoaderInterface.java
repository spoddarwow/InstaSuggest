/**
 * 
 */
package com.suggesthashtag.propertyloader.listPropertyLoader;

import java.util.List;

/**
 * @author sumitpoddar
 *
 */
public interface ListPropertyLoaderInterface {

	boolean isEligible();

	String getPattern();

	List initializeArrayList();
}
