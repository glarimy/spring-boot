package com.glarimy.spring.bank.data;

public class AccountRepositoryException extends RuntimeException {

	private static final long serialVersionUID = -6100686408974376229L;

	public AccountRepositoryException() {
	}

	public AccountRepositoryException(String message) {
		super(message);
	}

	public AccountRepositoryException(Throwable cause) {
		super(cause);
	}

	public AccountRepositoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccountRepositoryException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
