package com.verizon.dto;

import java.util.Date;
import java.util.List;

public class CustomerDetailsRequest {

	private String customerName;
	private String email;
	private String phoneNumber;
	private Long transactionId;
	private Date dateOfBirth;
	private String gender;
	private String passport;
	private Date customerActiveDate;
	private Date customerDeactiveDate;
	private List<CustomerAddressRequest> customerAddressRequest;
	private List<ServiceProviderDetailsRequest> serviceProviderDetailsRequest;
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
	public List<CustomerAddressRequest> getCustomerAddressRequest() {
		return customerAddressRequest;
	}
	public void setCustomerAddressRequest(List<CustomerAddressRequest> customerAddressRequest) {
		this.customerAddressRequest = customerAddressRequest;
	}
	public List<ServiceProviderDetailsRequest> getServiceProviderDetailsRequest() {
		return serviceProviderDetailsRequest;
	}
	public void setServiceProviderDetailsRequest(List<ServiceProviderDetailsRequest> serviceProviderDetailsRequest) {
		this.serviceProviderDetailsRequest = serviceProviderDetailsRequest;
	}


}

