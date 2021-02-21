package com.epam.task3.exception;

public class OvalException extends Exception {
	private static final long serialVersionUID = 1L;

	public OvalException() {
		super();
	}

	public OvalException(String message, Throwable cause) {
		super(message, cause);
	}

	public OvalException(String message) {
		super(message);
	}

	public OvalException(Throwable cause) {
		super(cause);
	}
}
