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
@Table(name = "biller")
public class BillerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "biller_id")
	private int billerId;

	@Column(name = "biller_name", length = 35, nullable = false)
	private String billerName;

	@Column(name = "biller_address", length = 75, nullable = false)
	private String billerAddress;

	@Column(name = "biller_categorey", length = 25, nullable = false)
	private String billerCategorey;

	@Column(name = "status", length = 25, nullable = false)
	private String status;
	
	@Column(name = "city", length = 25, nullable = false)
	private String city;
	
	@Column(name = "pincode", nullable = false)
	private int pincode;

	@Column(name = "create_biller_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date createBillerDate;

	@Column(name = "update_biller_date", length = 25, nullable = true)
	@Temporal(TemporalType.DATE)
	private Date updateBillerDate;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private CustomerModel customer;

	@OneToMany(mappedBy = "biller")
	private List<PaymentInstructionModel> payment;

//	===================================== GETTER AND SETTERS =====================================

	public Date getCreateBillerDate() {
		return createBillerDate;
	}

	public void setCreateBillerDate(Date createBillerDate) {
		this.createBillerDate = createBillerDate;
	}

	public Date getUpdateBillerDate() {
		return updateBillerDate;
	}

	public void setUpdateBillerDate(Date updateBillerDate) {
		this.updateBillerDate = updateBillerDate;
	}

	public List<PaymentInstructionModel> getPayment() {
		return payment;
	}

	public void setPayment(List<PaymentInstructionModel> payment) {
		this.payment = payment;
	}
	
	public int getBillerId() {
		return billerId;
	}

	public void setBillerId(int billerId) {
		this.billerId = billerId;
	}

	public String getBillerName() {
		return billerName;
	}

	public void setBillerName(String billerName) {
		this.billerName = billerName;
	}

	public String getBillerAddress() {
		return billerAddress;
	}

	public void setBillerAddress(String billerAddress) {
		this.billerAddress = billerAddress;
	}

	public String getBillerCategorey() {
		return billerCategorey;
	}

	public void setBillerCategorey(String billerCategorey) {
		this.billerCategorey = billerCategorey;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CustomerModel getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	

}
