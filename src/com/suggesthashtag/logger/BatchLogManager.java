/**
 * 
 */
package com.suggesthashtag.logger;

/**
 * @author sumitpoddar
 *
 */
public class BatchLogManager extends LogManager {

	/**
	 * @param batchName
	 */
	public BatchLogManager(String batchName) {
		super(batchName);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.suggesthashtag.logger.LogManager#getLoggerName()
	 */
	@Override
	public String getLoggerName() {
		// TODO Auto-generated method stub
		return super.batchName;
	}

}
