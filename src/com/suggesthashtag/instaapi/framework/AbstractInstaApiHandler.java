package com.suggesthashtag.instaapi.framework;

import org.apache.log4j.Logger;

import com.suggesthashtag.instaapi.SHTConstants;
import com.suggesthashtag.propertyloader.PropertyLoader;

/**
 * Abstract class used for all the Instagram API's
 * 
 * @author sumitpoddar
 *
 */
public abstract class AbstractInstaApiHandler {

	private PropertyLoader propertyLoader = new PropertyLoader();
	private static Logger logger = null;

	protected static void process(
			Class<? extends AbstractInstaApiHandler> callerClass, String[] args) {
		logger = Logger.getLogger(AbstractInstaApiHandler.class);

		// Init default Logger object;
		// Init Command Line object
		// Load property files
		// Cal execute method.

	}

	private String returnBuildedPropertyName(String environmentName) {
		StringBuffer propsNameBuf = new StringBuffer(
				(null != getPropsFileName() && !"".equals(getPropsFileName())) ? getPropsFileName()
						: "");
		propsNameBuf.append(environmentName).append(".property");
		return propsNameBuf.toString();
	}

	private String returnBuildedPropertyPath() {
		return (null != getPropsFilePath() && !"".equals(getPropsFilePath())) ? getPropsFilePath()
				: SHTConstants.defaultPropertyPath;
	}

	public abstract void execute();

	/**
	 * @return String - batch log file name.
	 */
	public abstract String getLoggerFileName();

	/**
	 * @return String - batch log file path.
	 */
	public abstract String getLoggerFilePath();

	/**
	 * @return String - batch property file name.
	 */
	public abstract String getPropsFileName();

	/**
	 * @return String - batch property file path.
	 */
	public abstract String getPropsFilePath();

}
