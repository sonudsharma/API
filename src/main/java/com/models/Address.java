package com.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADD_ID")
	private Integer id;

	@Column(name = "ADD_STREET1_NAME")
	private String Street1;

	@Column(name = "ADD_STREET2_NAME")
	private String Street2;

	@Column(name = "ADD_STREET3_NAME")
	private String Street3;

	@Column(name = "ADD_POSTAL_CODE")
	private String postalcode;

	@Column(name = "ADD_LATITUDE")
	private String lattitude;

	@Column(name = "ADD_LONGITUDE")
	private String longitude;

	@Column(name = "ADD_FULL_ADDRESS")
	private String fulladdress;

	@OneToOne
	@JoinColumn(name = "ADD_CIT_ID")
	private Cities city;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreet1() {
		return Street1;
	}

	public void setStreet1(String street1) {
		Street1 = street1;
	}

	public String getStreet2() {
		return Street2;
	}

	public void setStreet2(String street2) {
		Street2 = street2;
	}

	public String getStreet3() {
		return Street3;
	}

	public void setStreet3(String street3) {
		Street3 = street3;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getLattitude() {
		return lattitude;
	}

	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getFulladdress() {
		return fulladdress;
	}

	public void setFulladdress(String fulladdress) {
		this.fulladdress = fulladdress;
	}

	public Cities getCity() {
		return city;
	}

	public void setCity(Cities city) {
		this.city = city;
	}

}
