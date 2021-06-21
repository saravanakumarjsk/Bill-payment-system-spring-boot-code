package com.abcbank.service;


import java.util.*;


import com.abcbank.model.BillerModel;
import com.abcbank.model.CustomerModel;
import com.abcbank.model.PaymentInstructionModel;

public interface CustomerService {

	public Object getLoginDetails(CustomerModel customerModel);
	public Object getCustomerRegDetails(int id);
	public Object getSingleCustomerDetailsById(int id);
	public Object updateCustomerPreferedAccount(CustomerModel customerModel);
	
//	========================  biller ===========================
	
	public Object addBiller(BillerModel billerModel);
	public Object getAllBillerByCustomerID(int id);
	public Object getBillerByBillerID(int id);
	public Object updateBiller(BillerModel billerModel);
	
//	==================== payment instruction table ==========================
	
	public Object getCustPrefAcc(int id);
	public Object getPreffAccBalance(int id);
	public Object getBillerNameByCustId(int id);
	public Object getBlanceByAccNum(long acc_num);
	public Object getBillerIdByBillerName(String billerName);
	public Object insertMakePaymentDetails(PaymentInstructionModel paymentModel);
	
// ==================== payment history ==============================
	public Object getPmtCategoreyByCustId(int id);
	public Object getPaymentStatusByCustId(int id);
	public Object gehistoryTableDataByCustId(int id);
	
//	=================view payment details =================================
	
	public Object getPymtDetailsById(long id);
	public Object updatePymtByBillNum(PaymentInstructionModel payment);
	public Object deletePymtById(long id);

}
