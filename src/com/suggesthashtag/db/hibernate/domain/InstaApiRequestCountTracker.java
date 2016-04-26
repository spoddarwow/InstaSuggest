/**
 * 
 */
package com.suggesthashtag.db.hibernate.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author sumitpoddar
 *
 */
@Entity
@Table(name = "SHT_INSTA_REQ_CT_TRACKER")
public class InstaApiRequestCountTracker implements DBHibernateObject {

	/**
	 * SEQ_REQ_CT_ID
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SHT_CT_ID")
	public long shtCTId;

	@Column(name = "SHT_REQ_CD")
	public String shtAPIReguestCode;

	@Column(name = "SHT_REQ_URL")
	public String shtAPIRequestUrl;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "SHT_RES")
	public String shtAPIResponse;

	@Column(name = "SHT_REQ_CT")
	public int shtReqCount;

	@Column(name = "SHT_REQ_MD_DT")
	public Date shtRequestModifiedDate;

	@Column(name = "SHT_REQ_CT_DT")
	public Date shtRequestCreatedDate;

	public long getShtCTId() {
		return this.shtCTId;
	}

	public void setShtCTId(long shtCTId) {
		this.shtCTId = shtCTId;
	}

	public String getShtAPIReguestCode() {
		return this.shtAPIReguestCode;
	}

	public void setShtAPIReguestCode(String shtAPIReguestCode) {
		this.shtAPIReguestCode = shtAPIReguestCode;
	}

	public String getShtAPIRequestUrl() {
		return this.shtAPIRequestUrl;
	}

	public void setShtAPIRequestUrl(String shtAPIRequestUrl) {
		this.shtAPIRequestUrl = shtAPIRequestUrl;
	}

	public String getShtAPIResponse() {
		return this.shtAPIResponse;
	}

	public void setShtAPIResponse(String shtAPIResponse) {
		this.shtAPIResponse = shtAPIResponse;
	}

	public int getShtReqCount() {
		return this.shtReqCount;
	}

	public void setShtReqCount(int shtReqCount) {
		this.shtReqCount = shtReqCount;
	}

	public Date getShtRequestModifiedDate() {
		return this.shtRequestModifiedDate;
	}

	public void setShtRequestModifiedDate(Date shtRequestModifiedDate) {
		this.shtRequestModifiedDate = shtRequestModifiedDate;
	}

	public Date getShtRequestCreatedDate() {
		return this.shtRequestCreatedDate;
	}

	public void setShtRequestCreatedDate(Date shtRequestCreatedDate) {
		this.shtRequestCreatedDate = shtRequestCreatedDate;
	}

}
