package com.abcbank.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abcbank.model.BillerModel;
import com.abcbank.model.CustomerModel;
import com.abcbank.model.PaymentInstructionModel;
import com.abcbank.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/loginDetails", method = RequestMethod.POST)
	public Object getLoginDetails(@RequestBody CustomerModel customerModel) {
		return (customerService.getLoginDetails(customerModel));
	}

	@RequestMapping(value = "/getCustomerById/{id}", method = RequestMethod.GET)
	public Object getCustomerRegDetails2(@PathVariable int id) {
		return (customerService.getCustomerRegDetails(id));
	}

	@RequestMapping(value = "/getOneCustomerById/{id}", method = RequestMethod.GET)
	public Object getStudentById(@PathVariable int id) {
		return (customerService.getSingleCustomerDetailsById(id));
	}

	@RequestMapping(value = "/updateCustAcc", method = RequestMethod.PUT)
	public Object updateStudent(@RequestBody CustomerModel customerModel) {
//		System.out.println(customerModel.getPerferredAcc1()+" "+customerModel.getPerferredAcc2());
		return (customerService.updateCustomerPreferedAccount(customerModel));

	}

//	================= biller controller ======================================================
	@RequestMapping(value = "/addBiller", method = RequestMethod.POST)
	public Object addBillerById(@RequestBody BillerModel billerModel) {
		return (customerService.addBiller(billerModel));
	}

	@RequestMapping(value = "/getAllBillerByCustID/{id}", method = RequestMethod.GET)
	public Object getAllStudent(@PathVariable int id) {
//		System.out.println("inside this method");
		return (customerService.getAllBillerByCustomerID(id));
	}

	@RequestMapping(value = "/getBillerByBillerId/{id}", method = RequestMethod.GET)
	public Object updateBillerByBillerId(@PathVariable int id) {
//		System.out.println("inside this method");
		return (customerService.getBillerByBillerID(id));
	}

	@RequestMapping(value = "/updateBillerDetails", method = RequestMethod.PUT)
	public Object updateBillerDetails(@RequestBody BillerModel billerModel) {
		return (customerService.updateBiller(billerModel));
	}

//	================= payment instruction ======================================================

	@RequestMapping(value = "/getCustomerPrefAccById/{id}", method = RequestMethod.GET)
	public Object getCustomerPrefAccById(@PathVariable int id) {
		return (customerService.getCustPrefAcc(id));
	}
	
	@RequestMapping(value = "/getCustomerPrefAccBal/{id}", method = RequestMethod.GET)
	public Object getCustomerPrefAccBal(@PathVariable int id) {
		return (customerService.getPreffAccBalance(id));
	}
	
	@RequestMapping(value = "/getBillerNameByCustId/{id}", method = RequestMethod.GET)
	public Object getBillerName(@PathVariable int id) {
		return (customerService.getBillerNameByCustId(id));
	}
	
	@RequestMapping(value = "/getBalByAccNum/{accNum}", method = RequestMethod.GET)
	public Object getBalByAccNum(@PathVariable long accNum) {
		return (customerService.getBlanceByAccNum(accNum));
	}
	
	@RequestMapping(value = "/getBillerIdByBillerName/{name}", method = RequestMethod.GET)
	public Object getBillerIdByBillerName(@PathVariable String name) {
		return (customerService.getBillerIdByBillerName(name));
	}
	
	@RequestMapping(value = "/insertMakePayment", method = RequestMethod.POST)
	public Object insertMakePayment(@RequestBody PaymentInstructionModel paymentModel) {
		return (customerService.insertMakePaymentDetails(paymentModel));
	}
	
//	======================================= payment history ====================================
	
	@RequestMapping(value = "/getPmtCategoreyByCustId/{id}", method = RequestMethod.GET)
	public Object getPmtCategoreyByCustId(@PathVariable int id) {
		return (customerService.getPmtCategoreyByCustId(id));
	}
	
	@RequestMapping(value = "/getPaymentStatusByCustId/{id}", method = RequestMethod.GET)
	public Object getPaymentStatusByCustId(@PathVariable int id) {
		return (customerService.getPaymentStatusByCustId(id));
	}
	
	@RequestMapping(value = "/gehistoryTableDataByCustId/{id}", method = RequestMethod.GET)
	public Object gehistoryTableDataByCustId(@PathVariable int id) {
		return (customerService.gehistoryTableDataByCustId(id));
	}
	
	@RequestMapping(value = "/getPymtDetailsById/{id}", method = RequestMethod.GET)
	public Object getPymtDetailsById(@PathVariable int id) {
		return (customerService.getPymtDetailsById(id));
	}
	
	@RequestMapping(value = "/updatePymtByBillNum", method = RequestMethod.PUT)
	public Object updatePymtByBillNum(@RequestBody PaymentInstructionModel paymentModel) {
		System.out.println("this is inside the method");
		return (customerService.updatePymtByBillNum(paymentModel));
	}
	
	@RequestMapping(value = "/deletePymtById/{id}", method = RequestMethod.GET)
	public Object deletePymtById(@PathVariable long id) {
		return (customerService.deletePymtById(id));
	}
	

}
