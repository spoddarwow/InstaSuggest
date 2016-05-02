/**
 * 
 */
package com.suggesthashtag.db.hibernate.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

import com.suggesthashtag.instaapi.framework.SHTMainApp;
import com.suggesthashtag.propertyloader.PropertyLoader;

/**
 * @author sumitpoddar
 *
 */
@Entity
@Table(name = "SHT_IG_API_REQ_TRACKER")
public class SHTMediaPopularAPITracker implements DBHibernateObject {

	/**
	 * SEQ_REQ_CT_ID
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Transient
	private static final int totalLimitForThisApi = 0;

	/**
	 * 
	 */
	public SHTMediaPopularAPITracker() {
		PropertyLoader thisApiPropertyLoader = SHTMainApp.getPropertyLoader();
		//totalLimitForThisApi = thisApiPropertyLoader.
	}

	@Id
	@Column(name = "SHT_IG_REQ_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_IG_REQ_ID")
	@SequenceGenerator(name = "SEQ_IG_REQ_ID", sequenceName = "SEQ_IG_REQ_ID")
	private long shtIgReqId;

	@Column(name = "SHT_REQ_API_CD")
	private String shtAPIReguestCode;

	@Column(name = "SHT_REQ_API_URL")
	private String shtAPIRequestUrl;

	/*
	 * @Lob @Basic(fetch = FetchType.LAZY)
	 * 
	 * @Column(name = "SHT_API_RESPONSE")
	 */
	@Lob
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "SHT_API_RESPONSE", columnDefinition = "CLOB", nullable = true)
	private String shtAPIResponse;

	/*
	 * @Lob @Basic(fetch = FetchType.LAZY)
	 * 
	 * @Column(name = "SHT_API_EXCEPTION")
	 */
	@Lob
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "SHT_API_EXCEPTION", columnDefinition = "CLOB", nullable = true)
	private String shtAPIException;

	@Column(name = "SHT_REQ_TOT_CT")
	@Formula("SHT_REQ_TOT_CT + 1")
	private int shtReqTotalCount;

	@Column(name = "SHT_REQ_TOT_CT_REM")
	@Formula("SHT_REQ_TOT_CT_REM - 1")
	private int shtReqTotalCountRemaining;

	@Column(name = "SHT_REQ_API_CT")
	private int shtReqAPICount;

	@Column(name = "SHT_REQ_API_CT_REM")
	private int shtReqAPICountRemaining;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SHT_REQ_CT_DT", updatable = false)
	private Date shtRequestCreatedDate = new Date();

	public long getShtIgReqId() {
		return this.shtIgReqId;
	}

	public void setShtIgReqId(long shtIgReqId) {
		this.shtIgReqId = shtIgReqId;
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

	public String getShtAPIException() {
		return this.shtAPIException;
	}

	public void setShtAPIException(String shtAPIException) {
		this.shtAPIException = shtAPIException;
	}

	public int getShtReqTotalCount() {
		return this.shtReqTotalCount;
	}

	public void setShtReqTotalCount(int shtReqTotalCount) {
		this.shtReqTotalCount = shtReqTotalCount;
	}

	public int getShtReqTotalCountRemaining() {
		return this.shtReqTotalCountRemaining;
	}

	public void setShtReqTotalCountRemaining(int shtReqTotalCountRemaining) {
		this.shtReqTotalCountRemaining = shtReqTotalCountRemaining;
	}

	public int getShtReqAPICount() {
		return this.shtReqAPICount;
	}

	public void setShtReqAPICount(int shtReqAPICount) {
		this.shtReqAPICount = shtReqAPICount;
	}

	public int getShtReqAPICountRemaining() {
		return this.shtReqAPICountRemaining;
	}

	public void setShtReqAPICountRemaining(int shtReqAPICountRemaining) {
		this.shtReqAPICountRemaining = shtReqAPICountRemaining;
	}

	public Date getShtRequestCreatedDate() {
		return this.shtRequestCreatedDate;
	}

	public void setShtRequestCreatedDate(Date shtRequestCreatedDate) {
		this.shtRequestCreatedDate = shtRequestCreatedDate;
	}

}
