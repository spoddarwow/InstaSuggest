/**
 * 
 */
package com.suggesthashtag.db.hibernate;

import com.suggesthashtag.db.hibernate.domain.DBHibernateObject;

/**
 * @author sumitpoddar
 *
 */
public final class DBMain {

	protected boolean insertObject(DBHibernateObject hibernateObject){
		boolean isSuccess = false;
		if(hibernateObject != null){
			Session thisSession = DBConnectionInit.getInstance(propertyLoader)
		}
		return isSuccess;
	}
	
}
