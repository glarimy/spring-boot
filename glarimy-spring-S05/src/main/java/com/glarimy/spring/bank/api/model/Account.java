package com.glarimy.spring.bank.api.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account {
	@Id
	@GeneratedValue
	private int no;
	private double balance;
	private boolean active;
	@Embedded
	private CustomerData data;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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

	@Override
	public String toString() {
		return "Account [no=" + no + ", balance=" + balance + ", active=" + active + ", data=" + data
				+ ", transactions=" + transactions + "]";
	}

}
