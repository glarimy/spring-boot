package com.glarimy.spring.bank.api.model;

import java.util.Date;

public class Transaction {
	private int id;
	private Date date;
	private String type;
	private double amount;

	public Transaction() {

	}

	public Transaction(String type, double amount) {
		super();
		this.type = type;
		this.amount = amount;
		this.date = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", date=" + date + ", type=" + type + ", amount=" + amount + "]";
	}

}
