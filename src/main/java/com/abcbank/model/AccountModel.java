package com.abcbank.model;

import java.util.Date;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "account")
public class AccountModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_number", nullable = false)
	private long acccountNumber;
	
	@Column(name = "account_type", length = 20, nullable = false)
	private String account_type;
	
	@Column(name = "balance", nullable = false)
	private double balance;
	
	@Column(name = "status", length = 20, nullable = false)
	private String status;
	
	@Column(name = "open_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date openDate;
	
	@Column(name = "close_date", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date closeDate;
	
	@Column(name = "branch_ifsc", length = 20, nullable = false)
	private String branch_ifsc;
	
	@Column(name = "bill_pay_prefered", length = 20, nullable = false)
	private String billPayPrefered;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private CustomerModel customer;
	
	@OneToMany(mappedBy = "account")
	private List<PaymentInstructionModel> payment;
	
//	===================================== GETTER AND SETTERS =====================================

	public List<PaymentInstructionModel> getPayment() {
		return payment;
	}

	public void setPayment(List<PaymentInstructionModel> payment) {
		this.payment = payment;
	}

	public long getAcccountNumber() {
		return acccountNumber;
	}

	public void setAcccountNumber(long acccountNumber) {
		this.acccountNumber = acccountNumber;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public String getBranch_ifsc() {
		return branch_ifsc;
	}

	public void setBranch_ifsc(String branch_ifsc) {
		this.branch_ifsc = branch_ifsc;
	}

	public String getBillPayPrefered() {
		return billPayPrefered;
	}

	public void setBillPayPrefered(String billPayPrefered) {
		this.billPayPrefered = billPayPrefered;
	}

	public CustomerModel getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}
	

}
