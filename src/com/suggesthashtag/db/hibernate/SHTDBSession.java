/**
 * 
 */
package com.suggesthashtag.db.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author sumitpoddar
 *
 */
public class SHTDBSession {

	private Session session = null;

	/**
	 * 
	 */
	public SHTDBSession() {
		session = DBConnectionInit.getOpenSesssion();
	}

	public Session getSession() {
		return this.session;
	}

	public void beginTransaction() {
		this.session.beginTransaction();
	}

	public void close() {
		this.session.close();
	}

	public Transaction getTransaction() {
		return this.session.getTransaction();
	}

	public void rollback() {
		getTransaction().rollback();
	}
}
