package com.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Countries implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COU_ID")
	private Integer id;

	@Column(name = "COU_CODE")
	private String code;

	@Column(name = "COU_NAME")
	private String name;

	@Column(name = "COU_CONTINENT_NAME")
	private String continentName;

	@Column(name = "COU_CALLING_CODE")
	private String callingCode;

	@Column(name = "COU_RECORD_STATUS_FLAG")
	private String recordStatusFlag;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COU_RECORD_STATUS_DATE")
	private Date recordStatusDate;

	@Column(name = "COU_CREATED_USER_ID")
	private Integer createUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COU_CREATED_DATE")
	private Date createdDate;

	@Column(name = "COU_LAST_CHANGED_USER_ID")
	private Integer lastChangeUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COU_LAST_CHANGED_DATE")
	private Date lastChangeDate;

	@Column(name = "COU_TRANSACTION_GUID")
	private Character transactionGuid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COU_RECORD_TIMESTAMP")
	private Date recordTimeStamp;

	@Column(name = "COU_QC_FLAG_DONE")
	private String qcFlagDone;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

	public String getCallingCode() {
		return callingCode;
	}

	public void setCallingCode(String callingCode) {
		this.callingCode = callingCode;
	}

	public String getRecordStatusFlag() {
		return recordStatusFlag;
	}

	public void setRecordStatusFlag(String recordStatusFlag) {
		this.recordStatusFlag = recordStatusFlag;
	}

	public Date getRecordStatusDate() {
		return recordStatusDate;
	}

	public void setRecordStatusDate(Date recordStatusDate) {
		this.recordStatusDate = recordStatusDate;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getLastChangeUserId() {
		return lastChangeUserId;
	}

	public void setLastChangeUserId(Integer lastChangeUserId) {
		this.lastChangeUserId = lastChangeUserId;
	}

	public Date getLastChangeDate() {
		return lastChangeDate;
	}

	public void setLastChangeDate(Date lastChangeDate) {
		this.lastChangeDate = lastChangeDate;
	}

	public Character getTransactionGuid() {
		return transactionGuid;
	}

	public void setTransactionGuid(Character transactionGuid) {
		this.transactionGuid = transactionGuid;
	}

	public Date getRecordTimeStamp() {
		return recordTimeStamp;
	}

	public void setRecordTimeStamp(Date recordTimeStamp) {
		this.recordTimeStamp = recordTimeStamp;
	}

	public String getQcFlagDone() {
		return qcFlagDone;
	}

	public void setQcFlagDone(String qcFlagDone) {
		this.qcFlagDone = qcFlagDone;
	}

}
