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
	private boolean loadPropPerEnv = false;

	/**
	 * @param propertyFileName
	 * @param propertyFilePath
	 */
	public PropertyLoaderDetails(String propertyFileName) {
		setPropertyFileName(propertyFileName);
	}

	/**
	 * @param propertyFileName
	 * @param propertyFilePath
	 */
	public PropertyLoaderDetails(String propertyFileName,
			String propertyFilePath) {
		setPropertyFileName(propertyFileName);
		setPropertyFilePath(propertyFilePath);
	}

	/**
	 * @param propertyFileName
	 * @param propertyFilePath
	 */
	public PropertyLoaderDetails(String propertyFileName, boolean loadPropPerEnv) {
		this.loadPropPerEnv = loadPropPerEnv;
		setPropertyFileName(propertyFileName);
	}

	/**
	 * @param propertyFileName
	 * @param propertyFilePath
	 */
	public PropertyLoaderDetails(String propertyFileName,
			String propertyFilePath, boolean loadPropPerEnv) {
		this.loadPropPerEnv = loadPropPerEnv;
		setPropertyFileName(propertyFileName);
		setPropertyFilePath(propertyFilePath);
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
			if (this.loadPropPerEnv) {
				if (propertyFileName.endsWith(".properties")) {
					propertyFileName = (String) propertyFileName.subSequence(0,
							propertyFileName.lastIndexOf(".properties"));
				}
				propertyFileName += System.getProperty("environment", "");

			}
			if (!propertyFileName.endsWith(".properties")) {
				propertyFileName += ".properties";
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
		return (null != this.propertyFilePath) ? this.propertyFilePath
				+ this.propertyFileName : this.propertyFileName;
	}
}
