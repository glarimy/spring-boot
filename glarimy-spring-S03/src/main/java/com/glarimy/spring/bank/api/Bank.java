package com.glarimy.spring.bank.api;

import com.glarimy.spring.bank.api.exceptions.BankException;
import com.glarimy.spring.bank.api.exceptions.InvalidDataException;
import com.glarimy.spring.bank.api.model.CustomerData;

public interface Bank {
	public int openAccount(CustomerData data) throws InvalidDataException, BankException;
}
