package com.abcbank.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "payment_instruction")
public class PaymentInstructionModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bill_number", nullable = false)
	private long bill_number;

	@Column(name = "bill_amount", nullable = false)
	private long billAmount;

	@Column(name = "payment_due_date", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date paymentDueDate;

	@Column(name = "payment_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date paymentDate;

	@Column(name = "payment_status", nullable = false)
	private String paymentStatus;

	@ManyToOne
	@JoinColumn(name = "account_number", nullable = false)
	private AccountModel account;
	
	@ManyToOne
	@JoinColumn(name = "biller_id", nullable = false)
	private BillerModel biller;
	

//	===================================== GETTER AND SETTERS =====================================
	
	public long getBill_number() {
		return bill_number;
	}

	public void setBill_number(long bill_number) {
		this.bill_number = bill_number;
	}

	public long getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(long billAmount) {
		this.billAmount = billAmount;
	}

	public Date getPaymentDueDate() {
		return paymentDueDate;
	}

	public void setPaymentDueDate(Date paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public AccountModel getAccount() {
		return account;
	}

	public void setAccount(AccountModel account) {
		this.account = account;
	}

	public BillerModel getBiller() {
		return biller;
	}

	public void setBiller(BillerModel biller) {
		this.biller = biller;
	}


}
