package com.jm.exception;

public class UploadException extends Exception{

	public UploadException() {

	};

	public UploadException(String msg) {
		super(msg);
	};

	public UploadException(String msg,Throwable t) {

		super(msg,t);
	};
}
