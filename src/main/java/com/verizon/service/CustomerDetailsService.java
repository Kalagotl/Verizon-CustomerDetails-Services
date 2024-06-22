package com.verizon.service;

import com.verizon.entity.CustomerDetails;
import com.verizon.entity.ServiceProviderDetails;

public interface CustomerDetailsService {

	  /** Method to save customer details
     Parameters:
     - customerDetails: The customer details to be saved
     Returns:
    - The saved customer details 
	  
	  */
     
    CustomerDetails saveCustomerDetails(CustomerDetails customerDetails);
    
    ServiceProviderDetails getServiceProviderByCustomerId(Long customerId);
    
    

	Long getSpidByCustomerId(Long customerId);
   
}
	
