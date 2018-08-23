package com.glarimy.spring.bank.api.model;

import javax.persistence.Embeddable;

import com.glarimy.spring.bank.aspects.NotNull;
import com.glarimy.spring.bank.aspects.Positive;
import com.glarimy.spring.bank.aspects.Validatable;

@Validatable
@Embeddable
public class CustomerData {
	private String name;
	private long phoneNumber;

	public CustomerData() {

	}

	public CustomerData(String name, long phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	@NotNull
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Positive
	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
