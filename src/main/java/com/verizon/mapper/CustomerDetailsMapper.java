package com.verizon.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.verizon.dto.CustomerDetailsRequest;
import com.verizon.dto.ServiceProviderDetailsRequest;
import com.verizon.entity.CustomerAddress;
import com.verizon.entity.CustomerDetails;
import com.verizon.entity.ServiceProviderDetails;

@Component // Indicates that this class is a Spring component
public class CustomerDetailsMapper {
	private static final Logger logger = LogManager.getLogger(CustomerDetailsMapper.class);
    @Autowired // Autowiring CustomerAddressMapper dependency
    private CustomerAddressMapper customerAddressMapper;

    @Autowired // Autowiring ServiceProviderDetailsMapper dependency
    private ServiceProviderDetailsMapper serviceProviderDetailsMapper;

    // Method to map CustomerDetailsRequest to CustomerDetails entity
    public CustomerDetails mapCustomerDetails(CustomerDetailsRequest customerDetailsRequest) {
        // Creating a new CustomerDetails object
        CustomerDetails customerDetails = new CustomerDetails();
        // Mapping fields from CustomerDetailsRequest to CustomerDetails entity
        customerDetails.setCustomerName(customerDetailsRequest.getCustomerName());
        customerDetails.setEmail(customerDetailsRequest.getEmail());
        customerDetails.setCustomerActiveDate(customerDetailsRequest.getCustomerActiveDate());
        customerDetails.setDateOfBirth(customerDetailsRequest.getDateOfBirth());
        customerDetails.setPhoneNumber(customerDetailsRequest.getPhoneNumber());
        customerDetails.setCustomerDeactiveDate(customerDetailsRequest.getCustomerDeactiveDate());
        customerDetails.setTransactionId(customerDetailsRequest.getTransactionId());
        customerDetails.setGender(customerDetailsRequest.getGender());
        customerDetails.setPassport(customerDetailsRequest.getPassport());

        // Map Address
        if (customerDetailsRequest.getCustomerAddressRequest() != null) {
            // Mapping customer address if present
            CustomerAddress customerAddress = customerAddressMapper.mapAddress(customerDetailsRequest.getCustomerAddressRequest().get(0)); // Assuming only one address is present
            customerDetails.setAddress(customerAddress); // Setting the mapped customer address to customer details
        }

        // Map ServiceProviderDetails
        if (customerDetailsRequest.getServiceProviderDetailsRequest() != null && !customerDetailsRequest.getServiceProviderDetailsRequest().isEmpty()) {
            // Mapping service provider details if present
            ServiceProviderDetailsRequest serviceProviderRequest = customerDetailsRequest.getServiceProviderDetailsRequest().get(0); // Assuming only one service provider is present
            ServiceProviderDetails serviceProviderDetails = serviceProviderDetailsMapper.mapServiceProviderDetails(serviceProviderRequest); // Mapping service provider details
            //Map Parent to child
            customerDetails.setServiceProviderDetails(serviceProviderDetails); // Setting the mapped service provider details to customer details
            
            //Map child to parent
            List<CustomerDetails> customerDetailsSet = new ArrayList<CustomerDetails> ();
            customerDetailsSet.add(customerDetails);
            serviceProviderDetails.setCustomers(customerDetailsSet);       
        }

        return customerDetails; // Returning the mapped customerDetails object
    }
}