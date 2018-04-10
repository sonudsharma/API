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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "persons")
// @NamedQuery(name="persons.findAll", query="SELECT p FROM persons p")
public class Persons implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PER_ID")
	private Integer id;

	@Column(name = "PER_PERSON_ID")
	private Integer personId;

	@Column(name = "PER_FIRST_NAME")
	private String firstName;

	@Column(name = "PER_MIDDLE_NAME")
	private String middleName;

	@Column(name = "PER_LAST_NAME")
	private String lastName;

	@Column(name = "PER_SPECIALITY")
	private String speciality;

	@Column(name = "PER_SUFFIX")
	private String suffix;

	@Column(name = "PER_PREFIX")
	private String prefix;

	@Column(name = "PER_PREFER_NAME")
	private String preferName;

	@Column(name = "PER_GENDER")
	private String gender;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PER_DOB")
	private Date dob;

	@Column(name = "PER_WEIGHT")
	private String weight;

	@Column(name = "PER_HEIGHT")
	private String height;

	@Column(name = "PER_ADHARNUMBER")
	private String adharnumber;

	@Column(name = "PER_PHOTO_URL")
	private String photourl;

	@Column(name = "PER_RECORD_STATUS_FLAG")
	private String recordStatusFlag;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PER_RECORD_STATUS_DATE")
	private Date recordStatusDate;

	@Column(name = "PER_CREATED_USER_ID")
	private Integer createdUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PER_CREATED_DATE")
	private Date createdDate;

	@Column(name = "PER_LAST_CHANGED_USER_ID")
	private Integer lastChangedUserID;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PER_LAST_CHANGED_DATE")
	private Date lastChangedDate;

	@Column(name = "PER_TRANSACTION_GUID")
	private Character transactionGuid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PER_RECORD_TIMESTAMP")
	private Date recordTimeStamp;

	@Column(name = "PER_QC_FLAG_DONE")
	private String qcFlagDone;

	@Column(name = "PER_PHONE")
	private String phone;

	@ManyToOne
	@JoinColumn(name = "hospital_id")
	private Hospital hospital;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "PER_ADDRESS_ID")
	private Address address;

	@Formula(value = "GET_AGE(PER_DOB)")
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getPreferName() {
		return preferName;
	}

	public void setPreferName(String preferName) {
		this.preferName = preferName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
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

	public Integer getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(Integer createdUserId) {
		this.createdUserId = createdUserId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getLastChangedUserID() {
		return lastChangedUserID;
	}

	public void setLastChangedUserID(Integer lastChangedUserID) {
		this.lastChangedUserID = lastChangedUserID;
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

	public String getFullName() {
		String name = getFirstName() + " " + (StringUtils.isNotBlank(getMiddleName()) ? (getMiddleName() + " ") : "")
				+ getLastName();

		return name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getAdharnumber() {
		return adharnumber;
	}

	public void setAdharnumber(String adharnumber) {
		this.adharnumber = adharnumber;
	}

	public String getPhotourl() {
		return photourl;
	}

	public void setPhotourl(String photourl) {
		this.photourl = photourl;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
