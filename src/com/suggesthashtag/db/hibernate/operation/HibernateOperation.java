/**
 * 
 */
package com.suggesthashtag.db.hibernate.operation;

import org.hibernate.Session;

import com.suggesthashtag.db.hibernate.domain.DBHibernateObject;

/**
 * @author sumitpoddar
 *
 */
public class HibernateOperation {

	private final String ERROR_NOT_APPLICABLE = "This operation is not applicable for the selected operation type";

	public void process(Session hbSession, DBHibernateObject hibernateObject) {
		System.out.println(ERROR_NOT_APPLICABLE);
	}

	public void process(Session hbSession, String name,
			DBHibernateObject hibernateObject) {
		System.out.println(ERROR_NOT_APPLICABLE);
	}
}
