package com.jm.exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException() {

	};

	public UserNotFoundException(String msg) {
		super(msg);
	};

	public UserNotFoundException(String msg,Throwable t) {

		super(msg,t);
	};
}
