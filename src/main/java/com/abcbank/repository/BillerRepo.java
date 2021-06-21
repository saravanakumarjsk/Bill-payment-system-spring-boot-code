package com.abcbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abcbank.model.BillerModel;

@Repository
public interface BillerRepo extends JpaRepository<BillerModel, Integer> {
	
	@Query("select u from BillerModel u where u.customer.customer_id=:customer_id")
	List<BillerModel> getAllBillerById(@Param("customer_id") int customer_id);
	
	@Query("select u from BillerModel u where u.billerId=:id")
	BillerModel updateBillerById(@Param("id") int id);
	
	@Query("select u from BillerModel u where u.billerName=:billerName")
	BillerModel getBillerIdByBillerName(@Param("billerName") String billerName);
	
	@Query("select u from BillerModel u where u.customer.customer_id=:customer_id")
	List<BillerModel> getHistoryByCustId(@Param("customer_id") int customer_id);

}
