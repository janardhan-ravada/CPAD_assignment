package com.direct.from.form.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
@Table(name = "address" ,  catalog = "spring_social")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "house_number")
	private String houseNumber;

	@Column(name = "road")
	private String road;

	@Column(name = "street")
	private String street;

	@Column(name = "area")
	private String area;

	@Column(name = "mandal")
	private String mandal;

	@Column(name = "district")
	private String district;

	@Column(name = "state")
	private String state;

	@Column(name = "pincode")
	private String pinCode;

	@Column(name = "land_mark")
	private String landMark;

	@Column(name = "other_details")
	private String otherDetails;

	@Column(name = "address_type")
	private String addressType;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "alternative_number")
	private String alternativeNumber;

	@Column(name = "preferred_timings")
	private String preferredTimings;

	@Column(name = "consumer_id")
	private Long consumerId;

	@Column(name = "farmer_id")
	private Long farmerId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getMandal() {
		return mandal;
	}

	public void setMandal(String mandal) {
		this.mandal = mandal;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getOtherDetails() {
		return otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAlternativeNumber() {
		return alternativeNumber;
	}

	public void setAlternativeNumber(String alternativeNumber) {
		this.alternativeNumber = alternativeNumber;
	}

	public String getPreferredTimings() {
		return preferredTimings;
	}

	public void setPreferredTimings(String preferredTimings) {
		this.preferredTimings = preferredTimings;
	}

	public Long getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(Long consumerId) {
		this.consumerId = consumerId;
	}

	public Long getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(Long farmerId) {
		this.farmerId = farmerId;
	}

	public Address(Long id, String houseNumber, String road, String street, String area, String mandal, String district,
			String state, String pinCode, String landMark, String otherDetails, String addressType, String phoneNumber,
			String alternativeNumber, String preferredTimings, Long consumerId, Long farmerId) {
		super();
		this.id = id;
		this.houseNumber = houseNumber;
		this.road = road;
		this.street = street;
		this.area = area;
		this.mandal = mandal;
		this.district = district;
		this.state = state;
		this.pinCode = pinCode;
		this.landMark = landMark;
		this.otherDetails = otherDetails;
		this.addressType = addressType;
		this.phoneNumber = phoneNumber;
		this.alternativeNumber = alternativeNumber;
		this.preferredTimings = preferredTimings;
		this.consumerId = consumerId;
		this.farmerId = farmerId;
	}

	public Address() {
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(houseNumber).append(road).append(street).append(area)
				.append(mandal).append(district).append(state).append(pinCode).append(landMark).append(otherDetails)
				.append(addressType).append(phoneNumber).append(alternativeNumber).append(preferredTimings)
				.append(consumerId).append(farmerId).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return false;
		if (getClass() != obj.getClass()) {
			return false;
		}

		Address address = (Address) obj;
		return new EqualsBuilder().append(id, address.id).append(houseNumber, address.houseNumber)
				.append(road, address.road).append(street, address.street).append(area, address.area)
				.append(mandal, address.mandal).append(district, address.district).append(state, address.state)
				.append(pinCode, address.pinCode).append(landMark, address.landMark)
				.append(otherDetails, address.otherDetails).append(addressType, address.addressType)
				.append(phoneNumber, address.phoneNumber).append(alternativeNumber, address.alternativeNumber)
				.append(preferredTimings, address.preferredTimings).append(consumerId, address.consumerId)
				.append(farmerId, address.farmerId).isEquals();

	}

}
