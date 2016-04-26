/**
 * 
 */
package com.suggesthashtag.db.hibernate;

import com.suggesthashtag.db.hibernate.operation.HibernateDeleteOperations;
import com.suggesthashtag.db.hibernate.operation.HibernateFetchOperation;
import com.suggesthashtag.db.hibernate.operation.HibernateInsertOperations;
import com.suggesthashtag.db.hibernate.operation.HibernateInsertOrUpdateOperations;
import com.suggesthashtag.db.hibernate.operation.HibernateOperation;
import com.suggesthashtag.db.hibernate.operation.HibernateUpdateOperations;

/**
 * @author sumitpoddar
 *
 */
public enum DBCrudOperations {
	I("Insert", new HibernateInsertOperations()), U("Update",
			new HibernateUpdateOperations()), IOrU("Insert or Update",
			new HibernateInsertOrUpdateOperations()), D("Delete",
			new HibernateDeleteOperations()), F("Fetch",
			new HibernateFetchOperation());

	private String operationName = "";
	private HibernateOperation operationObject = null;

	/**
	 * @param operationName
	 * @param object
	 */
	private DBCrudOperations(String operationName,
			HibernateOperation operationObject) {
		this.operationName = operationName;
		this.operationObject = operationObject;
	}

	public String getOperationName() {
		return this.operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public HibernateOperation getOperationObject() {
		return this.operationObject;
	}

	public void setOperationObject(HibernateOperation operationObject) {
		this.operationObject = operationObject;
	}

}
