package com.verizon.dto;

import java.sql.Date;

public class ServiceProviderDetailsRequest {
    private Long id;
    private Long spid;
    private String providerName;
    private String providerAddress;
    private String providerContact;
    private String providerType;
    private String website;
    private String servicesOffered;
    private Date establishedDate;
    private double rating;
    

    // Getters and setters
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

}
