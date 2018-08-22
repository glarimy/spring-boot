package com.glarimy.spring.bank.api.exceptions;

public class InvalidDataException extends BankException {

	private static final long serialVersionUID = -3031130993130983698L;

	public InvalidDataException() {
	}

	public InvalidDataException(String message) {
		super(message);
	}

	public InvalidDataException(Throwable cause) {
		super(cause);
	}

	public InvalidDataException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidDataException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
