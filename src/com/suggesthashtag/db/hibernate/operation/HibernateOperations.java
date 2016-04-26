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
public interface HibernateOperations  {

	void process(Session hbSession, DBHibernateObject hibernateObject);

	void process(Session hbSession, String name,
			DBHibernateObject hibernateObject);
}
