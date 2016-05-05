/**
 * 
 */
package com.suggesthashtag.db.hibernate.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author sumitpoddar
 *
 */
@Entity
@Table(name = "SHT_IG_REQ_COUNT_TRACKR")
public class InstaApiRequestCountTracker implements DBHibernateObject {

	/**
	 * SEQ_REQ_COUNT_ID
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SHT_IG_CT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_IG_REQ_ID")
	@SequenceGenerator(name = "SEQ_IG_REQ_ID", sequenceName = "SEQ_IG_REQ_ID")
	private long shtCountId;

	@Column(name = "SHT_IG_API_REQ_CD")
	private String shtAPIReguestCode;

	@Column(name = "SHT_IG_API_REQ_URL")
	private String shtAPIRequestUrl;

	@Column(name = "SHT_IG_TOT_COUNT")
	private int shtIGTotalCount;

	@Column(name = "SHT_IG_TOT_COUNT_REM")
	private int shtIGTotalCountRemaining = 0;

	@Column(name = "SHT_IG_API_COUNT")
	private int shtIGAPICount;

	@Column(name = "SHT_IG_API_COUNT_REM")
	private int shtIGAPICountRemaining = 0;

	@Column(name = "SHT_IG_API_TT_REC")
	private int shtIGAPITimeTakenRecord;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SHT_REQ_MD_DT")
	private Date shtRequestModifiedDate = new Date();

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SHT_REQ_CT_DT", updatable = false)
	private Date shtRequestCreatedDate = new Date();

	public long getShtCountId() {
		return this.shtCountId;
	}

	public void setShtCountId(long shtCountId) {
		this.shtCountId = shtCountId;
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

	public int getShtIGTotalCount() {
		return this.shtIGTotalCount;
	}

	public void setShtIGTotalCount(int shtIGTotalCount) {
		this.shtIGTotalCount = shtIGTotalCount;
	}

	public int getShtIGTotalCountRemaining() {
		return this.shtIGTotalCountRemaining;
	}

	public void setShtIGTotalCountRemaining(int shtIGTotalCountRemaining) {
		this.shtIGTotalCountRemaining = shtIGTotalCountRemaining;
	}

	public int getShtIGAPICount() {
		return this.shtIGAPICount;
	}

	public void setShtIGAPICount(int shtIGAPICount) {
		this.shtIGAPICount = shtIGAPICount;
	}

	public int getShtIGAPICountRemaining() {
		return this.shtIGAPICountRemaining;
	}

	public void setShtIGAPICountRemaining(int shtIGAPICountRemaining) {
		this.shtIGAPICountRemaining = shtIGAPICountRemaining;
	}

	public int getShtIGAPITimeTakenRecord() {
		return this.shtIGAPITimeTakenRecord;
	}

	public void setShtIGAPITimeTakenRecord(int shtIGAPITimeTakenRecord) {
		this.shtIGAPITimeTakenRecord = shtIGAPITimeTakenRecord;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		System.out
				.println(((this.getShtCountId() == ((InstaApiRequestCountTracker) obj)
						.getShtCountId()) && (this.getShtAPIReguestCode()
						.equals(((InstaApiRequestCountTracker) obj)
								.getShtAPIReguestCode()))));
		return ((this.getShtCountId() == ((InstaApiRequestCountTracker) obj)
				.getShtCountId()) && (this.getShtAPIReguestCode()
				.equals(((InstaApiRequestCountTracker) obj)
						.getShtAPIReguestCode())));
	}

}
