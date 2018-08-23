package com.glarimy.spring.directory.api.exceptions;

public class DirectoryException extends RuntimeException {
	private static final long serialVersionUID = -3535004534594457494L;

	public DirectoryException() {
	}

	public DirectoryException(String message) {
		super(message);
	}

	public DirectoryException(Throwable cause) {
		super(cause);
	}

	public DirectoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public DirectoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
