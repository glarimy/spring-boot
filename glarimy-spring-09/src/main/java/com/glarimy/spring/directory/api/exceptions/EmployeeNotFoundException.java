package com.glarimy.spring.directory.api.exceptions;

public class EmployeeNotFoundException extends DirectoryException {

	private static final long serialVersionUID = -8695246778866582849L;

	public EmployeeNotFoundException() {
	}

	public EmployeeNotFoundException(String message) {
		super(message);
	}

	public EmployeeNotFoundException(Throwable cause) {
		super(cause);
	}

	public EmployeeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmployeeNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
