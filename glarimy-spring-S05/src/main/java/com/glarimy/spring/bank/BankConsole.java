package com.glarimy.spring.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.glarimy.spring.bank.api.Bank;
import com.glarimy.spring.bank.api.model.CustomerData;

@SpringBootApplication
public class BankConsole implements CommandLineRunner {
	Logger logger = LoggerFactory.getLogger(BankConsole.class);

	@Autowired
	Bank bank;

	@Override
	public void run(String... args) throws Exception {
		int accountNumber = bank.openAccount(new CustomerData("Krishna Mohan", 9731423166L));
		logger.debug("Account is successfully opened. A/C Number: " + accountNumber);
		logger.debug("Balance after depositing 100.00: " + bank.deposit(accountNumber, 100));
		logger.debug("Balance after widtrahwing 50:00: " + bank.withdraw(accountNumber, 50));
		logger.debug("Balance after depositing 200.00: " + bank.deposit(accountNumber, 200));
		logger.debug("Balance after depositing  50.00: " + bank.deposit(accountNumber, 50));
		logger.debug("Account Details: " + bank.getAccount(accountNumber));
	}

	public static void main(String[] args) {
		SpringApplication.run(BankConsole.class, args);
	}
}