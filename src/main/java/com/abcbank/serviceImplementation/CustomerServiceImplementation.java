package com.abcbank.serviceImplementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcbank.model.AccountModel;
import com.abcbank.model.BillerModel;
import com.abcbank.model.CustomerModel;
import com.abcbank.model.PaymentInstructionModel;
import com.abcbank.repository.AccountRepo;
import com.abcbank.repository.BillerRepo;
import com.abcbank.repository.CustomerReop;
import com.abcbank.repository.PaymentInstructionRepo;
import com.abcbank.service.CustomerService;
import java.util.*;

@Service
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	private CustomerReop customerRepo;

	@Autowired
	private AccountRepo accountRepo;

	@Autowired
	private BillerRepo billerRepo;

	@Autowired
	private PaymentInstructionRepo paymentRepo;

// ================================ getting login details ===========================================
	@Override
	@Transactional
	public Object getLoginDetails(CustomerModel customerModel) {

		CustomerModel customer = customerRepo.getDetails(customerModel.getUserName(), customerModel.getPassword());
		HashMap<String, Object> map = new HashMap<String, Object>();
		if (customer == null) {
			map.put("status", "404");
		} else {
			map.put("status", "200");
			map.put("CustomerID", customer.getCustomer_id());
			map.put("CustomerName", customer.getUserName());
			map.put("perferredAcc1", customer.getPerferredAcc1());
		}
		return map;
	}
	// ================================ getting customer registration details
	// =====================

	@Override
	@Transactional
	public Object getCustomerRegDetails(int id) {
		CustomerModel customer = customerRepo.getCustomerRegDetails(id);

		List<AccountModel> account = accountRepo.getCustomerRegDetails2(customer.getCustomer_id());

		List<Object> list1 = new ArrayList<Object>();

		for (AccountModel acc : account) {

			list1.add(acc.getAcccountNumber());

		}
		return list1;
	}
//	============================================= getting all customer deatils by id for updating preferred account ==================================================

	@Override
	public Object getSingleCustomerDetailsById(int id) {
		CustomerModel customer = customerRepo.getSingleCustomerById(id);

		HashMap<String, Object> map = new HashMap<String, Object>();

		if (customer == null) {
			map.put("status", "404");
		} else {
			map.put("customer_id", customer.getCustomer_id());
			map.put("aadhar", customer.getAadhar());
			map.put("bill_pay_registered", customer.getBillPayRegistered());
			map.put("city", customer.getCity());
			map.put("country", customer.getCountry());
			map.put("dob", customer.getDob());
			map.put("email", customer.getEmail());
			map.put("first_name", customer.getFirstName());
			map.put("gender", customer.getGender());
			map.put("last_name", customer.getLastName());
			map.put("mobile_number", customer.getMobileNumber());
			map.put("occupation", customer.getOccupation());
			map.put("pan", customer.getPan());
			map.put("password", customer.getPassword());
			map.put("pin", customer.getPin());
			map.put("salary", customer.getSalary());
			map.put("state", customer.getState());
			map.put("address", customer.getAddress());
			map.put("preferred_account1", customer.getPerferredAcc1());
			map.put("preferred_account2", customer.getPerferredAcc2());
			map.put("customer_name", customer.getUserName());
		}
		return map;

	}
//	============================================= updating preferred account for customer =================================================================================

	@Override
	public Object updateCustomerPreferedAccount(CustomerModel customerModel) {
		HashMap<String, String> map = new HashMap<String, String>();

		if (customerModel.getPerferredAcc1() == 0) {
			map.put("status", "error");
			map.put("message", "enter the preferred acc 1");
		} else if (customerModel.getPerferredAcc2() == 0) {
			map.put("status", "error");
			map.put("message", "enter the preferred acc 2");
		} else {
			customerRepo.saveAndFlush(customerModel);
			map.put("status", "200");
			map.put("message", "prefered account details updated sucessfully");
		}
		return map;
	}

//	================================ add new biller ============================================================

	@Override
	@Transactional
	public Object addBiller(BillerModel billerModel) {
		HashMap<String, String> map = new HashMap<String, String>();

		if (billerModel.getBillerName().isEmpty()) {
			map.put("status", "error");
			map.put("message", "enter the biller name");
		} else if (billerModel.getBillerAddress().isEmpty()) {
			map.put("status", "error");
			map.put("message", "enter the biller address");
		} else if (billerModel.getCity().isEmpty()) {
			map.put("status", "error");
			map.put("message", "enter the biller city");
		} else if (billerModel.getPincode() == 0) {
			map.put("status", "error");
			map.put("message", "enter the biller pincode");
		} else if (billerModel.getBillerCategorey().isEmpty()) {
			map.put("status", "error");
			map.put("message", "enter the biller categorey");
		} else {
			billerRepo.save(billerModel);
			map.put("status", "200");
			map.put("message", "biller details stored sucessfully");
		}

		return map;
	}
//	============================ getting all biller as list ===================================================

	@Override
	public Object getAllBillerByCustomerID(int id) {

		CustomerModel customer = customerRepo.getCustomerRegDetails(id);

		List<BillerModel> biller = billerRepo.getAllBillerById(customer.getCustomer_id());

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		for (BillerModel bill : biller) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("billerId", bill.getBillerId());
			map.put("billerName", bill.getBillerName());
			map.put("billerAddress", bill.getBillerAddress());
			map.put("billerCategorey", bill.getBillerCategorey());
			map.put("city", bill.getCity());
			map.put("status", bill.getStatus());
			map.put("pincode", bill.getPincode());
			map.put("createBillerDate", bill.getCreateBillerDate());
			map.put("customer_id", bill.getCustomer().getCustomer_id());

			list.add(map);
		}

		return list;

	}

//	============================getting the biller data ===================================================
	@Override
	public Object getBillerByBillerID(int id) {

		BillerModel bill = billerRepo.findById(id).orElse(null);

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("billerId", bill.getBillerId());
		map.put("billerName", bill.getBillerName());
		map.put("billerAddress", bill.getBillerAddress());
		map.put("billerCategorey", bill.getBillerCategorey());
		map.put("city", bill.getCity());
		map.put("status", bill.getStatus());
		map.put("pincode", bill.getPincode());
		map.put("createBillerDate", bill.getCreateBillerDate());
		map.put("customer_id", bill.getCustomer().getCustomer_id());

		return map;
	}

//	============================update the biller data ===================================================

	@Override
	public Object updateBiller(BillerModel billerModel) {
		HashMap<String, String> map = new HashMap<String, String>();

		if (billerModel.getBillerId() == 0) {
			map.put("status", "error");
			map.put("message", "enter the biller id");
		} else if (billerModel.getBillerName().isEmpty()) {
			map.put("status", "error");
			map.put("message", "enter the biller name");
		} else if (billerModel.getBillerAddress().isEmpty()) {
			map.put("status", "error");
			map.put("message", "enter the biller address");
		} else if (billerModel.getCity().isEmpty()) {
			map.put("status", "error");
			map.put("message", "enter the biller city");
		} else if (billerModel.getPincode() == 0) {
			map.put("status", "error");
			map.put("message", "enter the biller pincode");
		} else if (billerModel.getStatus().isEmpty()) {
			map.put("status", "error");
			map.put("message", "enter the biller status");
		} else if (billerModel.getBillerCategorey().isEmpty()) {
			map.put("status", "error");
			map.put("message", "enter the biller categorey");
		} else if (billerModel.getCreateBillerDate() == null) {
			map.put("status", "error");
			map.put("message", "enter the create biller date");
		} else {
			billerRepo.save(billerModel);
			map.put("status", "200");
			map.put("message", "biller details updated sucessfully");
		}

		return map;
	}
//	============================getting preffered account from customer table the biller data ===================================================

	@Override
	public Object getCustPrefAcc(int id) {

		CustomerModel customer = customerRepo.getCustPrefAccounts(id);

//		HashMap<String, Object> map = new LinkedHashMap<String, Object>();

		List<Long> list = new LinkedList<Long>();

		list.add(customer.getPerferredAcc1());
		list.add(customer.getPerferredAcc2());

//		map.put("preferredAcc1", customer.getPerferredAcc1());
//		map.put("preferredAcc2", customer.getPerferredAcc2());

		return list;
	}
//	============================getting the prefered account balance ===================================================

	@Override
	public Object getPreffAccBalance(int id) {

		List<AccountModel> account = accountRepo.getCustPrefAccBal(id);

		HashMap<String, Object> map = new LinkedHashMap<String, Object>();

		List<Double> list = new ArrayList<Double>();

		for (AccountModel acc : account) {

			list.add(acc.getBalance());
		}

//		int i = 1;
//		for (Double l : list) {
//			map.put("acc" + i, l);
//			i++;
//		}

		return list;
	}

//	============================getting the biller name ===================================================

	@Override
	@Transactional
	public Object getBillerNameByCustId(int id) {

		List<BillerModel> biller = billerRepo.getAllBillerById(id);

		List<String> list = new ArrayList<String>();

		for (BillerModel bill : biller) {
			list.add(bill.getBillerName());
		}

		return list;
	}
//	============================get balance by account number ===================================================

	@Override
	@Transactional
	public Object getBlanceByAccNum(long acc_num) {

		System.out.println("this is inside the service impl");
		AccountModel model = accountRepo.getBalByAccNum(acc_num);

		double accBal = model.getBalance();

		HashMap<String, Double> map = new LinkedHashMap<String, Double>();

		map.put("balance", model.getBalance());

		System.out.println(accBal);

		return map;
	}

//	============================== get biller id by biller name =====================================
	@Override
	public Object getBillerIdByBillerName(String billerName) {

		BillerModel biller = billerRepo.getBillerIdByBillerName(billerName);

		HashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("billerId", biller.getBillerId());

		return map;
	}
// =========== insert into payment table =========================================

	@Override
	@Transactional
	public Object insertMakePaymentDetails(PaymentInstructionModel paymentModel) {

		HashMap<String, String> map = new HashMap<String, String>();

		if (paymentModel.getBillAmount() == 0) {
			map.put("status", "error");
			map.put("message", "enter the bill amount");
		} else if (paymentModel.getPaymentDate() == null) {
			map.put("status", "error");
			map.put("message", "enter the payment date");
		} else if (paymentModel.getPaymentStatus().isEmpty()) {
			map.put("status", "error");
			map.put("message", "enter the status");
		} else if (paymentModel.getAccount().getAcccountNumber() == 0) {
			map.put("status", "error");
			map.put("message", "enter the enter the account number");
		} else if (paymentModel.getBiller().getBillerId() == 0) {
			map.put("status", "error");
			map.put("message", "enter the biller id");
		} else {

			AccountModel acc = accountRepo.getAllDetailByAccNum(paymentModel.getAccount().getAcccountNumber());
			double updatedBalAmount = acc.getBalance() - paymentModel.getBillAmount();
			acc.setBalance(updatedBalAmount);
			accountRepo.saveAndFlush(acc);
			paymentRepo.save(paymentModel);
			map.put("status", "200");
			map.put("message", "make payment details updated sucessfully");
		}

		return map;
	}
//	=================================== get all biller categorey by cust id ============================

	@Override
	@Transactional
	public Object getPmtCategoreyByCustId(int id) {

		List<BillerModel> biller = billerRepo.getAllBillerById(id);

		List<String> list = new ArrayList<String>();

		for (BillerModel bill : biller) {
			list.add(bill.getBillerCategorey());
		}

		return list;

	}
//	=================================== get all biller categorey by cust id ============================

	@Override
	public Object getPaymentStatusByCustId(int id) {

		List<BillerModel> biller = billerRepo.getAllBillerById(id);

		List<String> list = new ArrayList<String>();

		for (BillerModel bill : biller) {
			list.add(bill.getStatus());
		}

		return list;
	}
//	========================== getting date, categorey, sstatus, billerId ==================================

	@Override
	@Transactional
	public Object gehistoryTableDataByCustId(int id) {

		List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();

		List<BillerModel> biller = billerRepo.getHistoryByCustId(id);

		for (BillerModel bill : biller) {

			List<PaymentInstructionModel> payment = paymentRepo.getPaymentDetByBillerId(bill.getBillerId());
			HashMap<String, Object> map1 = new HashMap<String, Object>();

			for (PaymentInstructionModel pay : payment) {

				map1.put("billerName", bill.getBillerName());
				map1.put("billerCategorey", bill.getBillerCategorey());
				map1.put("status", bill.getStatus());
				map1.put("billerId", bill.getBillerId());

				map1.put("acccountNumber", pay.getAccount().getAcccountNumber());
				map1.put("billAmount", pay.getBillAmount());
				map1.put("bill_number", pay.getBill_number());
				map1.put("paymentDate", pay.getPaymentDate());

				list1.add(map1);
			}

		}

		return list1;
	}
//	============================== getting payment table deatils using bill_number ======================

	@Override
	@Transactional
	public Object getPymtDetailsById(long id) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		PaymentInstructionModel payment = paymentRepo.getPaymentTblDetailsById(id);

		map.put("acccountNumber", payment.getAccount().getAcccountNumber());
		map.put("billerName", payment.getBiller().getBillerName());
		map.put("paymentStatus", payment.getPaymentStatus());
		map.put("billerId", payment.getBiller().getBillerId());

		return map;
	}
//	========================= update payment table =======================

	@Override
	@Transactional
	public Object updatePymtByBillNum(PaymentInstructionModel payment) {

		HashMap<String, String> map = new HashMap<String, String>();

		
		if (payment.getBillAmount() == 0) {
			map.put("status", "error");
			map.put("message", "enter the bill amount");
		} else if (payment.getPaymentDate() == null) {
			map.put("status", "error");
			map.put("message", "enter the payment date");
		} else {
			long amount = payment.getBillAmount();
			payment.setBillAmount(amount);

			Date payDate = payment.getPaymentDate();
			payment.setPaymentDate(payDate);

			paymentRepo.saveAndFlush(payment);
			map.put("status", "200");
			map.put("message", "payment instructions details updated sucessfully");
		}

		return map;
	}

	@Override
	@Transactional
	public Object deletePymtById(long id) {
		PaymentInstructionModel payment = paymentRepo.getPaymentTblDetailsById(id);
		HashMap<String, String> map = new HashMap<String, String>();
		
		if(payment == null)
		{
			map.put("status", "error");
			map.put("message", "id does not exist");
		}
		else 
		{
			paymentRepo.delete(payment);
			map.put("status", "200");
			map.put("message", "payment instructions details deleted sucessfully");
		}
		return map;
	}

}
