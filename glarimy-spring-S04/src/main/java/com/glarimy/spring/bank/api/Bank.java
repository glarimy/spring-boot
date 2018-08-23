package com.glarimy.spring.bank.api;

import com.glarimy.spring.bank.api.exceptions.BankException;
import com.glarimy.spring.bank.api.exceptions.InvalidDataException;
import com.glarimy.spring.bank.api.model.Account;
import com.glarimy.spring.bank.api.model.CustomerData;

public interface Bank {
	public int openAccount(CustomerData data) throws InvalidDataException, BankException;

	public double deposit(int no, double amount) throws InvalidDataException, AccountNotFoundException, BankException;

	public double withdraw(int no, double amount) throws InvalidDataException, AccountNotFoundException, BankException;

	public Account getAccount(int id) throws AccountNotFoundException, BankException;
}
