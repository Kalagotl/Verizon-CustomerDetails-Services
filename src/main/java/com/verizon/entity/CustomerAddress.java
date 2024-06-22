package com.verizon.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity// Indicates that this class is an entity mapped to a database table
public class CustomerAddress {
	@Id // Indicates the primary key of the entity
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies the generation strategy for the primary key
	private Long addressId; // Primary key

	private String doorNumber; // Address details
	private String street;
	private String landmarks;
	private String village;
	private String mandal;
	private String city;
	private String district;
	private String state;
	private String country;

	// Getters and setters
	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLandmarks() {
		return landmarks;
	}

	public void setLandmarks(String landmarks) {
		this.landmarks = landmarks;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getMandal() {
		return mandal;
	}

	public void setMandal(String mandal) {
		this.mandal = mandal;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
