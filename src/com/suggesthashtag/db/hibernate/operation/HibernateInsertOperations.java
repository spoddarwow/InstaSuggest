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
public class HibernateInsertOperations extends HibernateOperation {

	@Override
	public void process(Session hbSession, DBHibernateObject hibernateObject) {
		hbSession.save(hibernateObject);

	}

	@Override
	public void process(Session hbSession, String name,
			DBHibernateObject hibernateObject) {
		hbSession.save(name, hibernateObject);

	}
}
