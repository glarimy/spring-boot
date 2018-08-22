package com.glarimy.spring.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glarimy.spring.bank.api.Bank;
import com.glarimy.spring.bank.api.exceptions.BankException;
import com.glarimy.spring.bank.api.exceptions.InvalidDataException;
import com.glarimy.spring.bank.api.model.Account;
import com.glarimy.spring.bank.api.model.CustomerData;
import com.glarimy.spring.bank.data.AccountRepository;

@Service
public class SimpleBank implements Bank {
	@Autowired
	private AccountRepository repo;

	@Override
	public int openAccount(CustomerData data) throws InvalidDataException, BankException {
		if (data == null || data.getName() == null || data.getName().trim().length() == 0 || data.getPhoneNumber() < 1)
			throw new InvalidDataException();
		Account account = new Account();
		account.setData(data);
		return repo.save(account);
	}

}
