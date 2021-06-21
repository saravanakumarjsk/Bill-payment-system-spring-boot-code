package com.abcbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abcbank.model.PaymentInstructionModel;

@Repository
public interface PaymentInstructionRepo extends JpaRepository<PaymentInstructionModel, Integer> {
	
	@Query("select u from PaymentInstructionModel u where u.biller.billerId=:billerId")
	List<PaymentInstructionModel> getPaymentDetByBillerId(@Param("billerId") int billerId);
	
	@Query("select u from PaymentInstructionModel u where u.bill_number=:bill_number")
	PaymentInstructionModel getPaymentTblDetailsById(@Param("bill_number") long bill_number);
	
	

}
