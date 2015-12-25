/**
 * 
 */
package com.suggesthashtag.logger;

/**
 * @author sumitpoddar
 *
 */
public enum LoggerLevel {

	DEBUG("Debug"), TRACE("Trace"), ERROR("Error"), FATAL("Fatal"), INFO("Info"), WARN(
			"Warn");

	private String levelName = "";

	/**
	 * @param levelName
	 */
	private LoggerLevel(String levelName) {
		this.levelName = levelName;
	}

	public String getLevelName() {
		return this.levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

}
