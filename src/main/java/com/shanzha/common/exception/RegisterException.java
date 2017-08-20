package com.shanzha.common.exception;

public class RegisterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RegisterException() {
		super();

	}

	public RegisterException(String msg) {
		super(msg);

	}

	public RegisterException(String message, Throwable cause) {
		super(message, cause);
	}
}
