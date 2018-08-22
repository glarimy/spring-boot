package com.glarimy.spring.bank.api.model;

public class CustomerData {
	private String name;
	private long phoneNumber;

	public CustomerData() {

	}

	public CustomerData(String name, long phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
