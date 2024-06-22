package com.verizon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.verizon.entity.CustomerDetails;
import com.verizon.entity.ServiceProviderDetails;

public interface ServiceProviderDetailsRepository  extends JpaRepository< ServiceProviderDetails, Long> {
	

	
}
