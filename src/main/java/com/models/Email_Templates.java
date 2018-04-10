package com.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "email_templates")
public class Email_Templates implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ETL_ID")
	private Integer id;

	@Column(name = "ETL_TEMPLATE_CODE")
	private String templateCode;

	@Column(name = "ETL_TEMPLATE_NAME")
	private String templateName;

	@Column(name = "ETL_SUBJECT_TEXT")
	private String subjectText;

	@Column(name = "ETL_MESSAGE_BODY")
	private String messageBody;

	@Column(name = "ETL_CATEGORY_NAME")
	private String categoryName;

	@Column(name = "ETL_RECORD_STATUS_FLAG")
	private String recordStatusFlg;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ETL_RECORD_STATUS_DATE")
	private Date recordStatusDate;

	@Column(nullable = true, name = "ETL_CREATED_USER_ID")
	private Integer createUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ETL_CREATED_DATE")
	private Date createdDate;

	@Column(nullable = true, name = "ETL_LAST_CHANGED_USER_ID")
	private Integer lastChangeUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ETL_LAST_CHANGED_DATE")
	private Date lastChangeDate;

	@Column(nullable = true, name = "ETL_TRANSACTION_GUID")
	private Character transactionGuid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ETL_RECORD_TIMESTAMP")
	private Date recordTimeStamp;

	@Column(name = "ETL_QC_FLAG_DONE")
	private String qcFlagDone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getSubjectText() {
		return subjectText;
	}

	public void setSubjectText(String subjectText) {
		this.subjectText = subjectText;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
