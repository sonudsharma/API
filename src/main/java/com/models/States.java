package com.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "states")
public class States implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STA_ID")
	private Integer id;
	
	@Column(name = "STA_CODE")
	private String code;
	
	@Column(name = "STA_NAME")
	private String name;
	
	@Column(name = "STA_RECORD_STATUS_FLAG")
	private String recordStatusFlg;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STA_RECORD_STATUS_DATE")
	private Date recordStatusDate;

	@Column(nullable = true, name = "STA_CREATED_USER_ID")
	private Integer createUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STA_CREATED_DATE")
	private Date createdDate;

	@Column(nullable = true, name = "STA_LAST_CHANGED_USER_ID")
	private Integer lastChangeUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STA_LAST_CHANGED_DATE")
	private Date lastChangeDate;

	@Column(nullable = true, name = "STA_TRANSACTION_GUID")
	private Character transactionGuid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STA_RECORD_TIMESTAMP")
	private Date recordTimeStamp;

	@Column(name = "STA_QC_FLAG_DONE")
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

	public String getRecordStatusFlg() {
		return recordStatusFlg;
	}

	public void setRecordStatusFlg(String recordStatusFlg) {
		this.recordStatusFlg = recordStatusFlg;
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
