package com.glarimy.spring.bank.service;

import com.glarimy.spring.bank.api.Bank;
import com.glarimy.spring.bank.api.exceptions.BankException;
import com.glarimy.spring.bank.api.exceptions.InvalidDataException;
import com.glarimy.spring.bank.api.model.Account;
import com.glarimy.spring.bank.api.model.CustomerData;
import com.glarimy.spring.bank.data.AccountRepository;

public class SimpleBank implements Bank {
	private AccountRepository repo;

	public AccountRepository getRepo() {
		return repo;
	}

	public void setRepo(AccountRepository repo) {
		this.repo = repo;
	}

	public SimpleBank() {
	}

	@Override
	public int openAccount(CustomerData data) throws InvalidDataException, BankException {
		if (data == null || data.getName() == null || data.getName().trim().length() == 0 || data.getPhoneNumber() < 1)
			throw new InvalidDataException();
		Account account = new Account();
		account.setData(data);
		return repo.save(account);
	}

}
