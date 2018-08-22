package com.glarimy.spring.directory.data;

public class EmployeeRepositoryException extends RuntimeException {

	private static final long serialVersionUID = -6100686408974376229L;

	public EmployeeRepositoryException() {
	}

	public EmployeeRepositoryException(String message) {
		super(message);
	}

	public EmployeeRepositoryException(Throwable cause) {
		super(cause);
	}

	public EmployeeRepositoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmployeeRepositoryException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
