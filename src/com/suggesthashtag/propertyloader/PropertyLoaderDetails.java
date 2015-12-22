/**
 * 
 */
package com.suggesthashtag.propertyloader;

/**
 * Bean to define the name and path of the properties file to load.
 * 
 * @author sumitpoddar
 *
 */
public class PropertyLoaderDetails {

	private String propertyFileName = "";
	private String propertyFilePath = "";

	/**
	 * @param propertyFileName
	 * @param propertyFilePath
	 */
	public PropertyLoaderDetails(String propertyFileName,
			String propertyFilePath) {
		super();
		this.propertyFileName = propertyFileName;
		this.propertyFilePath = propertyFilePath;
	}

	public String getPropertyFileName() {
		return this.propertyFileName;
	}

	public void setPropertyFileName(String propertyFileName) {
		if (propertyFileName != null) {
			if (propertyFileName.startsWith("/")) {
				propertyFileName = propertyFileName.substring(1);
			} else if (propertyFileName.startsWith("//")) {
				propertyFileName = propertyFileName.substring(2);
			}
		}
		this.propertyFileName = propertyFileName;
	}

	public String getPropertyFilePath() {
		return this.propertyFilePath;
	}

	public void setPropertyFilePath(String propertyFilePath) {
		if (propertyFilePath != null) {
			if (propertyFilePath.contains("/")
					&& !propertyFilePath.endsWith("/")) {
				propertyFilePath += "/";
			} else if (propertyFilePath.contains("//")
					&& !propertyFilePath.endsWith("//")) {
				propertyFilePath += "//";
			}
		}
		this.propertyFilePath = propertyFilePath;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.propertyFilePath + this.propertyFileName;
	}
}
