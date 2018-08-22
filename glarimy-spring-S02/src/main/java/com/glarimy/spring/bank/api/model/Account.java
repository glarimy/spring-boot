package com.glarimy.spring.bank.api.model;

import java.util.HashSet;
import java.util.Set;

public class Account {
	private int no;
	private double balance;
	private boolean active;
	private CustomerData data;
	private Set<Transaction> transactions = new HashSet<>();

	public Account() {

	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public CustomerData getData() {
		return data;
	}

	public void setData(CustomerData data) {
		this.data = data;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

}
