package com.abcbank.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "customer")
public class CustomerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private int customer_id;

	@Column(name = "first_name", length = 25, nullable = false)
	private String firstName;

	@Column(name = "last_name", length = 25, nullable = false)
	private String lastName;

	@Column(name = "dob", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column(name = "mobile_number", length = 10, nullable = false)
	private String mobileNumber;

	@Column(name = "email", length = 45, nullable = false)
	private String email;

	@Column(name = "address", length = 75, nullable = false)
	private String address;

	@Column(name = "pin", nullable = false)
	private int pin;

	@Column(name = "pan", length = 25, nullable = false)
	private String pan;

	@Column(name = "aadhar", length = 12, nullable = false)
	private String aadhar;

	@Column(name = "city", length = 25, nullable = false)
	private String city;

	@Column(name = "state", length = 25, nullable = false)
	private String state;

	@Column(name = "country", length = 25, nullable = false)
	private String country;

	@Column(name = "occupation", length = 35, nullable = false)
	private String occupation;

	@Column(name = "salary", nullable = false)
	private Double salary;

	@Column(name = "gender", length = 10, nullable = false)
	private String gender;

	@Column(name = "userName", length = 45, nullable = false)
	private String userName;

	@Column(name = "password", length = 35, nullable = false)
	private String password;

	@Column(name = "perferred_acc1", nullable = true)
	private Long perferredAcc1;

	@Column(name = "perferred_acc2", nullable = true)
	private Long perferredAcc2;

	@Column(name = "bill_pay_registered", length = 35, nullable = true)
	private String billPayRegistered;

	@OneToMany(mappedBy = "customer")
	private List<AccountModel> account;

	@OneToMany(mappedBy = "customer")
	private List<BillerModel> biller;

//	=================================== GETTER AND SETTERS ===========================================

	public int getCustomer_id() {
		return customer_id;
	}

	public List<AccountModel> getAccount() {
		return account;
	}

	public void setAccount(List<AccountModel> account) {
		this.account = account;
	}

	public List<BillerModel> getBiller() {
		return biller;
	}

	public void setBiller(List<BillerModel> biller) {
		this.biller = biller;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPerferredAcc1() {
		return perferredAcc1;
	}

	public void setPerferredAcc1(Long perferredAcc1) {
		this.perferredAcc1 = perferredAcc1;
	}

	public Long getPerferredAcc2() {
		return perferredAcc2;
	}

	public void setPerferredAcc2(Long perferredAcc2) {
		this.perferredAcc2 = perferredAcc2;
	}

	public String getBillPayRegistered() {
		return billPayRegistered;
	}

	public void setBillPayRegistered(String billPayRegistered) {
		this.billPayRegistered = billPayRegistered;
	}

}
