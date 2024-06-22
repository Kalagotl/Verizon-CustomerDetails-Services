package com.verizon.dto;

public class ServiceProvideDetailsResponse {
	private Long spid;
	private String providerName;
    private String providerAddress;
    private String providerContact;
    private String providerType;
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
	
}
