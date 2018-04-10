package com.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "users")
// @NamedQuery(name="users.findAll", query="SELECT u FROM user u")
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USR_ID")
	private Integer id;

	@Column(name = "USR_ACCOUNT_NAME")
	private String username;

	@Column(name = "USR_PASSWORD")
	private String password;

	@Column(name = "USR_DESCRIPTION")
	private String description;

	@Column(name = "USR_TYPE")
	private String type;

	@Column(name = "USR_SOURCE_TYPE")
	private String sourceType;

	@Column(name = "USR_ACCOUNT_LOCK_FLAG")
	private String accountLockFlag;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "USR_PASSWORD_REMIND_DATE")
	private Date passRemindDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "USR_LAST_LOGIN_DATE")
	private Date lastLoginDate;

	@Column(nullable = true, name = "USR_UNSUCCESSFUL_LOGIN_ATTEMPT")
	private Integer unsuccessfulLoginAtmp;

	@Column(name = "USR_RECORD_STATUS_FLAG")
	private String recordStatusFlg;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "USR_RECORD_STATUS_DATE")
	private Date recordStatusDate;

	@Column(nullable = true, name = "USR_CREATED_USER_ID")
	private Integer createUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "USR_CREATED_DATE")
	private Date createdDate;

	@Column(nullable = true, name = "USR_LAST_CHANGED_USER_ID")
	private Integer lastChangeUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "USR_LAST_CHANGED_DATE")
	private Date lastChangeDate;

	@Column(nullable = true, name = "USR_TRANSACTION_GUID")
	private Character transactionGuid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "USR_RECORD_TIMESTAMP")
	private Date recordTimeStamp;

	@Column(name = "USR_QC_FLAG_DONE")
	private String qcFlagDone;

	@Column(name = "USR_TOKEN")
	private String token;

	@Column(name = "USR_EMAIL")
	private String userEmail;

	@Column(name = "USR_PIN")
	private String pin;

	@Column(name = "USR_EXTERNAL_ID")
	private String externalid;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USR_PER_ID")
	private Persons person;

	public String getExternalid() {
		return externalid;
	}

	public void setExternalid(String externalid) {
		this.externalid = externalid;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getAccountLockFlag() {
		return accountLockFlag;
	}

	public void setAccountLockFlag(String accountLockFlag) {
		this.accountLockFlag = accountLockFlag;
	}

	public Date getPassRemindDate() {
		return passRemindDate;
	}

	public void setPassRemindDate(Date passRemindDate) {
		this.passRemindDate = passRemindDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Integer getUnsuccessfulLoginAtmp() {
		return unsuccessfulLoginAtmp;
	}

	public void setUnsuccessfulLoginAtmp(Integer unsuccessfulLoginAtmp) {
		this.unsuccessfulLoginAtmp = unsuccessfulLoginAtmp;
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

	public Persons getPerson() {
		return person;
	}

	public void setPerson(Persons person) {
		this.person = person;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}