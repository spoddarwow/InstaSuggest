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
public class HibernateUpdateOperations extends HibernateOperation {

	@Override
	public void process(Session hbSession, DBHibernateObject hibernateObject) {
		hbSession.update(hibernateObject);
	}

	@Override
	public void process(Session hbSession, String name,
			DBHibernateObject hibernateObject) {
		hbSession.update(name, hibernateObject);
	}

}
