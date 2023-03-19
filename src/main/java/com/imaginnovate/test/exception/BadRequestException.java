package com.imaginnovate.test.exception;

public class BadRequestException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public BadRequestException(String s) {
		super(s);
	}

}
