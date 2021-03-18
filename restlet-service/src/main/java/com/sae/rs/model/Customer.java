package com.sae.rs.model;

public class Customer {
	private long id;
	private String name;
	private String address;
	private String accountNumber;

	public Customer() {
	}

	public Customer(long id, String name, String address, String accountNumber) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.accountNumber = accountNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
