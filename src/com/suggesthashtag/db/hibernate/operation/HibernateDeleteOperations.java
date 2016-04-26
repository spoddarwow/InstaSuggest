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
public class HibernateDeleteOperations extends HibernateOperation {

	@Override
	public void process(Session hbSession, DBHibernateObject hibernateObject) {
		// TODO Auto-generated method stub
		hbSession.delete(hibernateObject);
	}

}
