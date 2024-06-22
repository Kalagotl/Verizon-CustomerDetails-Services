package com.verizon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.verizon.entity.CustomerDetails;
import com.verizon.entity.ServiceProviderDetails;
@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long> {

    @Query("SELECT cd.serviceProviderDetails FROM CustomerDetails cd WHERE cd.customerId = :customerId")
    ServiceProviderDetails findServiceProviderDetailsByCustomerId(Long customerId);

	CustomerDetails findByCustomerId(Long customerId);
	@Query("SELECT cd.serviceProviderDetails.spid FROM CustomerDetails cd WHERE cd.customerId = :customerId")
    Long findSpidByCustomerId(Long customerId);
	
}


