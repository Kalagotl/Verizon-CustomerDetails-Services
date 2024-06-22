package com.verizon.mapper;

import org.springframework.stereotype.Component;
import com.verizon.dto.CustomerAddressRequest;
import com.verizon.entity.CustomerAddress;

@Component // Indicates that this class is a Spring component
public class CustomerAddressMapper {
	// Method to map CustomerAddressRequest to CustomerAddress entity
	public CustomerAddress mapAddress(CustomerAddressRequest customerAddressRequest) {
		// Creating a new CustomerAddress object
		CustomerAddress customerAddress = new CustomerAddress();
		// Mapping fields from CustomerAddressRequest to CustomerAddress entity
		customerAddress.setAddressId(customerAddressRequest.getAddressId());
		customerAddress.setDoorNumber(customerAddressRequest.getDoorNumber());
		customerAddress.setStreet(customerAddressRequest.getStreet());
		customerAddress.setVillage(customerAddressRequest.getVillage());
		customerAddress.setLandmarks(customerAddressRequest.getLandmarks());
		customerAddress.setMandal(customerAddressRequest.getMandal());
		customerAddress.setCity(customerAddressRequest.getCity());
		customerAddress.setDistrict(customerAddressRequest.getDistrict());
		customerAddress.setState(customerAddressRequest.getState());
		customerAddress.setCountry(customerAddressRequest.getCountry());

		return customerAddress; // Returning the mapped CustomerAddress entity
	}
}





