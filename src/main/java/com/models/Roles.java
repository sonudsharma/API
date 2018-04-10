package com.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "roles")
//@NamedQuery(name="roles.findAll", query="SELECT r FROM roles r")
public class Roles implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROL_ID")
	private Integer id;
	
	@Column(name = "ROL_NAME")
	private String name;
	
	@Column(name = "ROL_CODE")
	private String code;
	
	@Column(name = "ROL_DESCRIPTION")
	private String description;
	
	@Column(name = "ROL_RECORD_STATUS_FLAG")
	private String recordStatusFlag;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ROL_RECORD_STATUS_DATE")
	private Date recordStatusDate;
	
	@Column(name = "ROL_CREATED_USER_ID")
	private Integer createdUserID;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ROL_CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "ROL_LAST_CHANGED_USER_ID")
	private Integer lastChangedUserId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ROL_LAST_CHANGED_DATE")
	private Date lastChangedDate;
	
	@Column(name = "ROL_TRANSACTION_GUID")
	private Character transactionGuid;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ROL_RECORD_TIMESTAMP")
	private Date recordTimeStamp;
	
	@Column(name = "ROL_QC_FLAG_DONE")
	private String qcFlagDone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Integer getCreatedUserID() {
		return createdUserID;
	}

	public void setCreatedUserID(Integer createdUserID) {
		this.createdUserID = createdUserID;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getLastChangedUserId() {
		return lastChangedUserId;
	}

	public void setLastChangedUserId(Integer lastChangedUserId) {
		this.lastChangedUserId = lastChangedUserId;
	}

	public Date getLastChangedDate() {
		return lastChangedDate;
	}

	public void setLastChangedDate(Date lastChangedDate) {
		this.lastChangedDate = lastChangedDate;
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
