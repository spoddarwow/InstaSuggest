/**
 * 
 */
package com.suggesthashtag.propertyloader.listPropertyLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sumitpoddar
 *
 */
public class StringListPropertyLoader implements ListPropertyLoaderInterface {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.suggesthashtag.propertyloader.listPropertyLoader.
	 * ListPropertyLoaderInterface#isEligible()
	 */
	@Override
	public boolean isEligible() {
		// TODO Auto-generated method stub
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.suggesthashtag.propertyloader.listPropertyLoader.
	 * ListPropertyLoaderInterface#getPattern()
	 */
	@Override
	public String getPattern() {
		// TODO Auto-generated method stub
		return "List<([a-zA-Z]+)>\\[(.*)\\]$";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.suggesthashtag.propertyloader.listPropertyLoader.
	 * ListPropertyLoaderInterface#initializeArrayList()
	 */
	@Override
	public List initializeArrayList() {
		// TODO Auto-generated method stub
		return new ArrayList<String>();
	}
}
