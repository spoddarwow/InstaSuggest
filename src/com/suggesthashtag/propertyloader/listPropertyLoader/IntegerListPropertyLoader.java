/**
 * 
 */
package com.suggesthashtag.propertyloader.listPropertyLoader;

/**
 * @author sumitpoddar
 *
 */
public class IntegerListPropertyLoader implements ListPropertyLoaderInterface {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.suggesthashtag.propertyloader.listPropertyLoader.
	 * ListPropertyLoadrerInterface#isEligible()
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
	 * ListPropertyLoadrerInterface#getPattern()
	 */
	@Override
	public String getPattern() {
		// TODO Auto-generated method stub
		return "(^\"[a-zA-Z-0-9\\s]+\"(,+))$";
	}

}
