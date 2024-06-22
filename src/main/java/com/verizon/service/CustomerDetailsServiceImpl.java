package com.verizon.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.entity.CustomerDetails;
import com.verizon.entity.ServiceProviderDetails;
import com.verizon.repository.CustomerDetailsRepository;
import com.verizon.repository.ServiceProviderDetailsRepository;

@Service // Spring service annotation to indicate this class as a service component
public class CustomerDetailsServiceImpl implements CustomerDetailsService {
	private static final Logger logger = LogManager.getLogger(CustomerDetailsServiceImpl.class);
    @Autowired // Spring annotation for automatic dependency injection
    private CustomerDetailsRepository customerDetailsRepository; // Repository for customer details
    @Autowired
    private ServiceProviderDetailsRepository serviceProviderDetailsRepository;
    @Override
    public CustomerDetails saveCustomerDetails(CustomerDetails customerDetails) {
    	 logger.info("Saving customer details for customer: {}", customerDetails.getCustomerName());
    	ServiceProviderDetails serviceProviderDetails = customerDetails.getServiceProviderDetails();

        // Save the serviceProviderDetails first if it's not already saved
        if (serviceProviderDetails.getId() == null) {
            serviceProviderDetailsRepository.save(serviceProviderDetails);
            logger.debug("ServiceProviderDetails saved: {}", serviceProviderDetails.getProviderName());
        }
        customerDetails.setCustomerId( serviceProviderDetails.getSpid());
        // Now save the customerDetails
        customerDetailsRepository.save(customerDetails);
        return customerDetails; // Saving and returning the customer details
    }
    
    public ServiceProviderDetails getServiceProviderByCustomerId(Long customerId) {
    	logger.info("Fetching service provider details for customerId: {}", customerId);
        return customerDetailsRepository.findServiceProviderDetailsByCustomerId(customerId);
    }
   

    public Long getSpidByCustomerId(String customerId) {
        CustomerDetails customerDetails = customerDetailsRepository.findByCustomerId(Long.parseLong(customerId));
        if (customerDetails != null) {
            ServiceProviderDetails serviceProviderDetails = customerDetails.getServiceProviderDetails();
            if (serviceProviderDetails != null) {
                return serviceProviderDetails.getSpid();
            } else {
                logger.error("ServiceProviderDetails not found for customerId: " + customerId);
                return null; // Return null or handle as needed
            }
        } else {
            logger.error("CustomerDetails not found for customerId: " + customerId);
            return null; // Return null or handle as needed
        }
    }
    @Override
    public Long getSpidByCustomerId(Long customerId) {
        return customerDetailsRepository.findSpidByCustomerId(customerId);
    }
    
   
    }     

  