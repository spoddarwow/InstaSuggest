/**
 * 
 */
package com.suggesthashtag.instaapi.apiCountManager;

import java.util.ArrayList;
import java.util.List;

import com.suggesthashtag.db.hibernate.DBUtil;
import com.suggesthashtag.db.hibernate.domain.DBHibernateObject;
import com.suggesthashtag.db.hibernate.domain.InstaApiRequestCountTracker;
import com.suggesthashtag.instaapi.framework.AbstractSHTBatchHandler;
import com.suggesthashtag.logger.LoggerLevel;
import com.suggesthashtag.propertyloader.PropertyLoaderDetails;
import com.suggesthashtag.propertyloader.exception.PropertyException;
import com.suggesthashtag.propertyloader.jsonObjects.apiCount.InstaApiCountManager;
import com.suggesthashtag.propertyloader.jsonObjects.apiCount.InstaApiDetails;

/**
 * @author sumitpoddar
 *
 */
public class SHTInstaAPICountManager extends AbstractSHTBatchHandler {

	private final static String thisBatchName = "SHTInstaAPICountManager";

	/**
	 * @param batchName
	 */
	public SHTInstaAPICountManager(String batchName) {
		super(batchName);
	}

	public static void main(String[] args) {
		new SHTInstaAPICountManager(thisBatchName).process(
				SHTInstaAPICountManager.class, args);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.suggesthashtag.instaapi.framework.AbstractSHTBatchHandler#execute()
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		log("Executing the SHTInstaAPICountManager.");

		try {
			List<DBHibernateObject> listToInsert = buildInsertApiCountObjects();
			if (listToInsert != null && !listToInsert.isEmpty()) {
				DBUtil.insertObjects(listToInsert,
						propertyLoader.getInteger("db.batch_size", "20"));
			}

		} catch (PropertyException exception) {
			log(LoggerLevel.ERROR, exception.getMessage(),
					exception.fillInStackTrace());
		}
		log("Execution of the SHTInstaAPICountManager is over.");
	}

	private List<DBHibernateObject> buildInsertApiCountObjects()
			throws PropertyException {
		List<DBHibernateObject> finalApiListToInsert = new ArrayList<DBHibernateObject>();
		List<DBHibernateObject> listToInsertWdApiCount = new ArrayList<DBHibernateObject>();
		InstaApiCountManager countManager = (InstaApiCountManager) propertyLoader
				.getObject("apiToConsider");
		int totalCount = countManager.getTotalIGApiLimit();
		List<InstaApiDetails> apiList = countManager.getApis();
		int totaldistributedCount = totalCount / apiList.size();
		int totalDistributedCountRemaining = totalCount % apiList.size();
		for (InstaApiDetails api : apiList) {
			InstaApiRequestCountTracker requestCountTracker = new InstaApiRequestCountTracker();
			requestCountTracker.setShtAPIReguestCode(api.getApiCode());
			requestCountTracker.setShtAPIRequestUrl(api.getApiURL());
			totalDistributedCountRemaining += ((api.getApiCount() > 0) ? totaldistributedCount
					- api.getApiCount()
					: 0);
			requestCountTracker.setShtIGAPICount(api.getApiCount());
			if (api.getApiCount() == 0) {
				finalApiListToInsert.add(requestCountTracker);
				requestCountTracker.setShtIGTotalCount(totaldistributedCount);
			} else {
				listToInsertWdApiCount.add(requestCountTracker);
				requestCountTracker.setShtIGTotalCount(api.getApiCount());
			}
		}
		if (totalDistributedCountRemaining > 0) {
			finalApiListToInsert = updateInsertApiCountObjectsWithRemCount(
					finalApiListToInsert, totalDistributedCountRemaining);
		}
		finalApiListToInsert.addAll(listToInsertWdApiCount);
		return finalApiListToInsert;
	}

	private List<DBHibernateObject> updateInsertApiCountObjectsWithRemCount(
			List<DBHibernateObject> listToInsertWdoutApiCount,
			int totalDistributedCountRemaining) throws PropertyException {
		int totaldistributedCount = totalDistributedCountRemaining
				/ listToInsertWdoutApiCount.size();
		int totalCountRemaining = totalDistributedCountRemaining
				% listToInsertWdoutApiCount.size();
		for (int i = 0; i < listToInsertWdoutApiCount.size(); i++) {
			InstaApiRequestCountTracker requestCountTracker = (InstaApiRequestCountTracker) listToInsertWdoutApiCount
					.get(i);
			requestCountTracker.setShtIGTotalCount(requestCountTracker
					.getShtIGTotalCount()
					+ totaldistributedCount
					+ ((totalCountRemaining != 0) ? 1 : 0));
			totalCountRemaining -= (totalCountRemaining != 0) ? 1 : 0;
			listToInsertWdoutApiCount.remove(i);
			listToInsertWdoutApiCount.add(i, requestCountTracker);
		}
		return listToInsertWdoutApiCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.suggesthashtag.instaapi.framework.AbstractSHTBatchHandler#
	 * getPropertyLoadDetails()
	 */
	@Override
	public PropertyLoaderDetails getPropertyLoadDetails() {
		return new PropertyLoaderDetails("instaApiCountManager.properties");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.suggesthashtag.instaapi.framework.AbstractSHTBatchHandler#
	 * getPropertyLoadDetailsList()
	 */
	@Override
	public List<PropertyLoaderDetails> getPropertyLoadDetailsList() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.suggesthashtag.logger.LogManager#getLoggerName()
	 */
	@Override
	public String getLoggerName() {
		return thisBatchName;
	}

}
