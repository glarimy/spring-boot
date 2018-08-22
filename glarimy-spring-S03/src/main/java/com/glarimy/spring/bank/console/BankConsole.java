package com.glarimy.spring.bank.console;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.glarimy.spring.bank.api.Bank;
import com.glarimy.spring.bank.api.model.CustomerData;
import com.glarimy.spring.bank.configuration.BankConfiguration;

public class BankConsole {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
			context.register(BankConfiguration.class);
			context.refresh();
			Bank bank = context.getBean(Bank.class);
			int accountNumber = bank.openAccount(new CustomerData("Krishna Mohan", -9731423166L));
			System.out.println("Account is successfully opened. A/C Number: " + accountNumber);
		}
	}

}
