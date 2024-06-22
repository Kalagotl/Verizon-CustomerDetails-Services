package com.verizon.entity;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity // Indicates that this class is an entity mapped to a database table
public class CustomerDetails {
	@Id // Indicates the primary key of the entity
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies the generation strategy for the primary key
	private Long customerId; // Primary key
	private String customerName; // Customer details
	private String email;
	private String phoneNumber;
	private Long transactionId;
	private Date dateOfBirth;
	private String gender;
	private String passport;
	private Date customerActiveDate;
	private Date customerDeactiveDate;

	@OneToOne(cascade = CascadeType.ALL) // Defines a one-to-one relationship with CustomerAddress entity
	@JoinColumn(name = "address_id", referencedColumnName = "addressId") // Specifies the foreign key column
	private CustomerAddress address; // One-to-one relationship with CustomerAddress

	//@ManyToOne
	@ManyToOne(fetch = FetchType.LAZY)// Defines a many-to-one relationship with ServiceProviderDetails entity
	@JoinColumn(name = "cust_id", referencedColumnName = "id") // Specifies the foreign key column
	@JsonBackReference
	private ServiceProviderDetails serviceProviderDetails; // Many-to-one relationship with ServiceProviderDetails

	// Getters and setters for the entity properties
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public Date getCustomerActiveDate() {
		return customerActiveDate;
	}

	public void setCustomerActiveDate(Date customerActiveDate) {
		this.customerActiveDate = customerActiveDate;
	}

	public Date getCustomerDeactiveDate() {
		return customerDeactiveDate;
	}

	public void setCustomerDeactiveDate(Date customerDeactiveDate) {
		this.customerDeactiveDate = customerDeactiveDate;
	}

	public CustomerAddress getAddress() {
		return address;
	}

	public void setAddress(CustomerAddress address) {
		this.address = address;
	}

	public ServiceProviderDetails getServiceProviderDetails() {
		return serviceProviderDetails;
	}

	public void setServiceProviderDetails(ServiceProviderDetails serviceProviderDetails) {
		this.serviceProviderDetails = serviceProviderDetails;
	}

}




