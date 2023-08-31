package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="maincustomer")
public class CustomerModel {
	@Id
	private int customerId;
	private String customerName;
	private String emailId;
	private String address;
	private String password;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public CustomerModel(int customerId, String customerName, String emailId, String address, String password) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.emailId = emailId;
		this.address = address;
		this.password = password;
	}
	public CustomerModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
