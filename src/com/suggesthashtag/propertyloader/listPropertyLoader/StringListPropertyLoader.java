/**
 * 
 */
package com.suggesthashtag.propertyloader.listPropertyLoader;

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

}
