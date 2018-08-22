package com.glarimy.spring.bank.api.exceptions;

public class BankException extends RuntimeException {
	private static final long serialVersionUID = -3535004534594457494L;

	public BankException() {
	}

	public BankException(String message) {
		super(message);
	}

	public BankException(Throwable cause) {
		super(cause);
	}

	public BankException(String message, Throwable cause) {
		super(message, cause);
	}

	public BankException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
