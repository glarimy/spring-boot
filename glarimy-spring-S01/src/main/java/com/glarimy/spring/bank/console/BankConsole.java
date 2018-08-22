package com.glarimy.spring.bank.console;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.glarimy.spring.bank.api.Bank;
import com.glarimy.spring.bank.api.model.CustomerData;

public class BankConsole {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml")) {
			Bank bank = context.getBean(Bank.class);
			int accountNumber = bank.openAccount(new CustomerData("Krishna Mohan", 9731423166L));
			System.out.println("Account is successfully opened. A/C Number: " + accountNumber);
		}
	}

}
