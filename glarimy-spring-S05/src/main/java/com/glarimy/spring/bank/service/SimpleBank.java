package com.glarimy.spring.bank.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glarimy.spring.bank.api.AccountNotFoundException;
import com.glarimy.spring.bank.api.Bank;
import com.glarimy.spring.bank.api.exceptions.BankException;
import com.glarimy.spring.bank.api.exceptions.InvalidDataException;
import com.glarimy.spring.bank.api.model.Account;
import com.glarimy.spring.bank.api.model.CustomerData;
import com.glarimy.spring.bank.api.model.Transaction;
import com.glarimy.spring.bank.data.AccountRepository;

@Service
public class SimpleBank implements Bank {
	@Autowired
	private AccountRepository repo;

	@Override
	@Transactional
	public int openAccount(CustomerData data) throws InvalidDataException, BankException {
		Account account = new Account();
		account.setData(data);
		repo.save(account);
		return account.getNo();
	}

	@Override
	@Transactional
	public double deposit(int no, double amount) throws InvalidDataException, AccountNotFoundException, BankException {
		Account account = repo.findById(no).orElse(null);
		if (account == null)
			throw new AccountNotFoundException();
		Transaction tx = new Transaction();
		tx.setAmount(amount);
		tx.setDate(new Date());
		tx.setType("CR");
		account.setBalance(account.getBalance() + amount);
		account.getTransactions().add(tx);
		return account.getBalance();
	}

	@Override
	@Transactional
	public double withdraw(int no, double amount) throws InvalidDataException, AccountNotFoundException, BankException {
		Account account = repo.findById(no).orElse(null);
		if (account == null)
			throw new AccountNotFoundException();
		if (amount > account.getBalance())
			throw new InvalidDataException();
		Transaction tx = new Transaction();
		tx.setAmount(amount);
		tx.setDate(new Date());
		tx.setType("DB");
		account.setBalance(account.getBalance() - amount);
		account.getTransactions().add(tx);
		return account.getBalance();
	}

	@Override
	@Transactional
	public Account getAccount(int id) throws AccountNotFoundException, BankException {
		Account account = repo.findById(id).orElse(null);
		if (account == null)
			throw new AccountNotFoundException();
		return account;
	}

}
