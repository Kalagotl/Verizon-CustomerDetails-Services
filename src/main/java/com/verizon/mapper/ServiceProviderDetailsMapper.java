package com.verizon.mapper;

import org.springframework.stereotype.Component;
import com.verizon.dto.ServiceProviderDetailsRequest;
import com.verizon.entity.ServiceProviderDetails;

@Component // Indicates that this class is a Spring component
public class ServiceProviderDetailsMapper {

	// Method to map ServiceProviderDetailsRequest to ServiceProviderDetails entity
	public ServiceProviderDetails mapServiceProviderDetails(ServiceProviderDetailsRequest serviceProviderDetailsRequest) {
		// Creating a new ServiceProviderDetails object
		ServiceProviderDetails serviceProviderDetails = new ServiceProviderDetails();
		// Mapping fields from ServiceProviderDetailsRequest to ServiceProviderDetails entity
		serviceProviderDetails.setSpid(serviceProviderDetailsRequest.getSpid());
		serviceProviderDetails.setProviderName(serviceProviderDetailsRequest.getProviderName());
		serviceProviderDetails.setProviderAddress(serviceProviderDetailsRequest.getProviderAddress());
		serviceProviderDetails.setProviderContact(serviceProviderDetailsRequest.getProviderContact());
		serviceProviderDetails.setProviderType(serviceProviderDetailsRequest.getProviderType());
		serviceProviderDetails.setWebsite(serviceProviderDetailsRequest.getWebsite());
		serviceProviderDetails.setServicesOffered(serviceProviderDetailsRequest.getServicesOffered());
		serviceProviderDetails.setEstablishedDate(serviceProviderDetailsRequest.getEstablishedDate());
		serviceProviderDetails.setRating(serviceProviderDetailsRequest.getRating());

		return serviceProviderDetails; // Returning the mapped serviceProviderDetails object
	}
}





