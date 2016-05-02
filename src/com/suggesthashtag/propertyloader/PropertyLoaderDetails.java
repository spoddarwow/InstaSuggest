/**
 * 
 */
package com.suggesthashtag.propertyloader;

import java.util.HashSet;

/**
 * Bean to define the name and path of the properties file to load.
 * 
 * @author sumitpoddar
 *
 */
public class PropertyLoaderDetails {

	private static HashSet<String> environmentNoneligiblefolder = new HashSet<String>();

	static {
		environmentNoneligiblefolder.add("universal");
	}

	private String propertyFileName = "";
	private String propertyFilePath = "";

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

	public String getPropertyFileName() {
		return this.propertyFileName;
	}

	public void setPropertyFileName(String propertyFileName) {
		if (propertyFileName.startsWith("//")) {
			propertyFileName = propertyFileName.substring(2,
					propertyFileName.length());
		} else if (propertyFileName.startsWith("/")) {
			propertyFileName = propertyFileName.substring(1,
					propertyFileName.length());
		}
		this.propertyFileName = propertyFileName;
	}

	public String getPropertyFilePath() {
		return this.propertyFilePath;
	}

	public void setPropertyFilePath(String propertyFilePath) {
		if (propertyFilePath != null) {
			if (propertyFilePath.contains("//")
					&& !propertyFilePath.endsWith("//")) {
				propertyFilePath += "//";
			} else if (!propertyFilePath.endsWith("/")) {
				propertyFilePath += "/";
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
		String propertyFullPath = ((null != this.propertyFilePath) && (!""
				.equals(this.propertyFilePath))) ? this.propertyFilePath
				+ this.propertyFileName : this.propertyFileName;

		String folderStartWith = getFolderFirstName(this.propertyFilePath);
		StringBuffer strbufPropertyFullPath = new StringBuffer();
		if (!environmentNoneligiblefolder.contains(folderStartWith)) {
			if (propertyFullPath.contains("//")) {
				strbufPropertyFullPath
						.append(System.getProperty("environment"))
						.append((!propertyFullPath.startsWith("//")) ? "//"
								: "").append(propertyFullPath);
			} else {
				strbufPropertyFullPath
						.append(System.getProperty("environment"))
						.append((!propertyFullPath.startsWith("/")) ? "/" : "")
						.append(propertyFullPath);
			}
		} else {
			strbufPropertyFullPath.append(propertyFullPath);
		}

		return strbufPropertyFullPath.toString();
	}

	/**
	 * @param propertyFullPath
	 * @return
	 */
	private String getFolderFirstName(String propertyFullPath) {
		String firstFolderName = "";
		if (propertyFullPath.startsWith("//")) {
			propertyFullPath = propertyFullPath.substring(2);

		} else if (propertyFullPath.startsWith("/")) {
			propertyFullPath = propertyFullPath.substring(1);

		}
		if (propertyFullPath.contains("//")) {
			firstFolderName = propertyFullPath.substring(0,
					propertyFullPath.indexOf("//"));
		} else if (propertyFullPath.contains("/")) {
			firstFolderName = propertyFullPath.substring(0,
					propertyFullPath.indexOf("/"));
		} else {
			firstFolderName = propertyFullPath;
		}
		return firstFolderName;
	}
}
