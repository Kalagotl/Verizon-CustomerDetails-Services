package com.verizon.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.dto.CustomerAddressRequest;
import com.verizon.dto.CustomerAddressResponse;
import com.verizon.dto.CustomerDetailsRequest;
import com.verizon.dto.CustomerDetailsResponse;
import com.verizon.dto.ServiceProviderDetailsRequest;
import com.verizon.entity.CustomerAddress;
import com.verizon.entity.CustomerDetails;
import com.verizon.entity.ServiceProviderDetails;
import com.verizon.mapper.CustomerAddressMapper;
import com.verizon.mapper.CustomerDetailsMapper;
import com.verizon.mapper.ServiceProviderDetailsMapper;
import com.verizon.service.CustomerDetailsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//Indicating that this class is a REST controller
@RestController
//URL mapping for this controller
@RequestMapping("/cust")
public class CustomerControl {
	// Annotation for automatic dependency injection
	// Dependency injection for CustomerAddressMapper
	private  CustomerAddressMapper customerAddressMapper;
	@Autowired
	private CustomerDetailsService customerDetailsService; // Dependency injection for CustomerDetailsService
	@Autowired
	private CustomerDetailsMapper customerDetailsMapper;// Dependency injection for CustomerDetailsMapper
	// Endpoint for saving customer details
	@Autowired
	private ServiceProviderDetailsMapper serviceProviderDetailsMapper;

    CustomerControl(CustomerAddressMapper customerAddressMapper) {
        this.customerAddressMapper = customerAddressMapper;
    }
	// Endpoint for saving customer details
	@PostMapping(value = "/customerdetails", consumes = "application/json", produces = "application/json") // Annotation to handle HTTP POST requests
	public CustomerDetailsResponse SaveCustomerDetails(@RequestBody CustomerDetailsRequest customerDetailsRequest) {
		CustomerDetailsResponse customerDetailsResponse = new CustomerDetailsResponse(); // Initialize the response object
		List<String> messages = new ArrayList();// Initialize the list to hold validation messages
		try 
		{
			// Validate phone number
			// Check if phone number is null
			if(customerDetailsRequest.getPhoneNumber()==null) 
			{
				messages.add("Phone Number Must Not null");
			}
			// Check if phone number is exactly 10 digits
			if (customerDetailsRequest.getPhoneNumber().length()<10 || customerDetailsRequest.getPhoneNumber().length()>10 ) 
			{
				messages.add("Phone Number must be 10 digits");
			}


			// Validate PassPort
			//Passport Must Not null
			if (customerDetailsRequest.getPassport() ==null) {
				messages.add(" Must Provide New service provider and  cannot be null.");

			} 


			List<CustomerAddressRequest> addressRequests = customerDetailsRequest.getCustomerAddressRequest();
			if (addressRequests != null) {
				for (CustomerAddressRequest addressRequest : addressRequests) {
					// Check each property of addressRequest for null or empty values and add appropriate messages
					if (addressRequest.getMandal() == null || addressRequest.getMandal().isEmpty()) 
					{
						messages.add("Mandal must not be null or empty");
					}

					if (addressRequest.getDistrict() == null || addressRequest.getDistrict().isEmpty()) 
					{
						messages.add("Mandal must not be null or empty");
					}
					if (addressRequest.getCity() == null || addressRequest.getCity().isEmpty()) 
					{
						messages.add("Mandal must not be null or empty");
					}
					if (addressRequest.getState() == null || addressRequest.getState().isEmpty()) 
					{
						messages.add("Mandal must not be null or empty");
					}
					if (addressRequest.getCountry() == null && addressRequest.getCountry().isEmpty()) 
					{
						messages.add("Mandal must not be null or empty");

					}


				}
			} 
			// Validate ServiceProviderDetails
			List<ServiceProviderDetailsRequest> serviceProviderRequests = customerDetailsRequest.getServiceProviderDetailsRequest();
			if (serviceProviderRequests != null) {
				for (ServiceProviderDetailsRequest serviceProviderRequest : serviceProviderRequests) {
					// Loop through each service provider request
                    // Check each property of serviceProviderRequest for null or empty values and add appropriate messages
					if (serviceProviderRequest.getProviderName() == null || serviceProviderRequest.getProviderName().isEmpty()) {
						messages.add("Provider Name must not be null or empty");
					}
					if (serviceProviderRequest.getProviderAddress() == null || serviceProviderRequest.getProviderAddress().isEmpty()) {
						messages.add("Provider Address must not be null or empty");
					}
					if (serviceProviderRequest.getProviderContact() == null || serviceProviderRequest.getProviderContact().isEmpty()) {
						messages.add("Provider Contact must not be null or empty");
					}
					if (serviceProviderRequest.getProviderType() == null || serviceProviderRequest.getProviderType().isEmpty()) {
						messages.add("Provider Type must not be null or empty");
					}
					// Add additional validations for other properties
				}
			} 
			else {
				messages.add("Service Provider Details Request list must not be null");
			}

			// If no validation errors, proceed with mapping and saving the customer details
			if (messages.isEmpty())
			{


				CustomerDetails customerDetails = customerDetailsMapper.mapCustomerDetails(customerDetailsRequest);// Map the request to entity

				customerDetailsService.saveCustomerDetails(customerDetails);// Save the customer details using the service

			}

		}
		catch(Exception e) 
		{
			messages.add("An error occurred: " + e.getMessage()); // Catch and add any exceptions to messages
		}
		finally 
		{
			customerDetailsResponse.setMessages(messages);// Set the messages in the response object
		}

		return customerDetailsResponse;// Return the response object
	}

    private static final Logger logger = LogManager.getLogger(CustomerControl.class);


    @GetMapping("/{cust_id}")
    public ServiceProviderDetails getServiceProviderById(@PathVariable Long cust_id) {
        logger.info("Received request to get service provider with id: " + cust_id);
        ServiceProviderDetails serviceProviderDetails = customerDetailsService.getServiceProviderByCustomerId(cust_id);
        if (serviceProviderDetails != null) 
        {
            logger.info("Service provider found: " + serviceProviderDetails.toString());
        } 
        else {
            logger.warn("Service provider with id " + cust_id + " not found.");
        }
        return serviceProviderDetails;
    }
    
    @GetMapping("/spid/{customerId}")
    public Long getSpidByCustomerId(@PathVariable Long customerId) {
        return customerDetailsService.getSpidByCustomerId(customerId);
    }

}
