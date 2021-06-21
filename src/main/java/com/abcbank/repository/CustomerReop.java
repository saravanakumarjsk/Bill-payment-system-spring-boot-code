package com.abcbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abcbank.model.CustomerModel;

@Repository
public interface CustomerReop extends JpaRepository<CustomerModel, Integer> {

	@Query("select u from CustomerModel u where u.userName=:userName and u.password=:password")
	CustomerModel getDetails(@Param("userName") String userName, @Param("password") String password);
	
	@Query("select u from CustomerModel u where u.customer_id=:customer_id")
	CustomerModel getCustomerRegDetails(@Param("customer_id") int customer_id);
	
	@Query("select u from CustomerModel u where u.customer_id=:customer_id")
	CustomerModel getSingleCustomerById(@Param("customer_id") int customer_id);
	
	@Query("select u from CustomerModel u where u.customer_id=:customer_id")
	CustomerModel getCustPrefAccounts(@Param("customer_id") int customer_id);
	
	
	
}
