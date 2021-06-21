package com.abcbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abcbank.model.AccountModel;

@Repository
public interface AccountRepo extends JpaRepository<AccountModel, Integer>  {
	
	@Query("select u from AccountModel u where u.customer.customer_id=:customer_id")
	List<AccountModel> getCustomerRegDetails2(@Param("customer_id") int customer_id);
	
	@Query("select u from AccountModel u where u.customer.customer_id=:customer_id")
	List<AccountModel> getCustPrefAccBal(@Param("customer_id") int customer_id);
	
	@Query("select u from AccountModel u where u.acccountNumber=:acccountNumber")
	AccountModel getBalByAccNum(@Param("acccountNumber") long acccountNumber);

	@Query("select u from AccountModel u where u.acccountNumber=:acccountNumber")
	AccountModel getAllDetailByAccNum(@Param("acccountNumber") long acccountNumber);
	
	

}
