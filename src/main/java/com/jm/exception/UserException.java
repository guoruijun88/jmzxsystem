package com.jm.exception;

public class UserException extends RuntimeException{

	public UserException() {

	};

	public UserException(String msg) {
		super(msg);
	};

	public UserException(String msg,Throwable t) {

		super(msg,t);
	};
}
