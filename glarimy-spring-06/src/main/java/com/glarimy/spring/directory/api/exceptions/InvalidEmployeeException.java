package com.glarimy.spring.directory.api.exceptions;

public class InvalidEmployeeException extends DirectoryException {

	private static final long serialVersionUID = -3031130993130983698L;

	public InvalidEmployeeException() {
	}

	public InvalidEmployeeException(String message) {
		super(message);
	}

	public InvalidEmployeeException(Throwable cause) {
		super(cause);
	}

	public InvalidEmployeeException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidEmployeeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
