package com.verizon.entity;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity // Indicates that this class is an entity mapped to a database table
public class ServiceProviderDetails {
	@Id // Indicates the primary key of the entity
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies the generation strategy for the primary key
	private Long id; // New Primary key

	@NotNull  // Specifies that the column should contain unique values
	private Long spid; // Unique field for service provider ID

	private String providerName; // Service provider details
	private String providerAddress;
	private String providerContact;
	private String providerType;
	private String website;
	private String servicesOffered;
	private Date establishedDate;
	private double rating;

	@OneToMany(mappedBy = "serviceProviderDetails") // Defines a one-to-many relationship with CustomerDetails entity
	@JsonManagedReference
	private List<CustomerDetails> customers; // One-to-many relationship with CustomerDetails

	// Getters and setters for the entity properties
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSpid() {
		return spid;
	}

	public void setSpid(Long spid) {
		this.spid = spid;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getProviderAddress() {
		return providerAddress;
	}

	public void setProviderAddress(String providerAddress) {
		this.providerAddress = providerAddress;
	}

	public String getProviderContact() {
		return providerContact;
	}

	public void setProviderContact(String providerContact) {
		this.providerContact = providerContact;
	}

	public String getProviderType() {
		return providerType;
	}

	public void setProviderType(String providerType) {
		this.providerType = providerType;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getServicesOffered() {
		return servicesOffered;
	}

	public void setServicesOffered(String servicesOffered) {
		this.servicesOffered = servicesOffered;
	}

	public Date getEstablishedDate() {
		return establishedDate;
	}

	public void setEstablishedDate(Date establishedDate) {
		this.establishedDate = establishedDate;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public List<CustomerDetails> getCustomers() {
		return customers;
	}

	public void setCustomers(List<CustomerDetails> customers) {
		this.customers = customers;
	}
}