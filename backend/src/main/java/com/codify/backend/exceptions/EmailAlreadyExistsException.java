package com.codify.backend.exceptions;

public class EmailAlreadyExistsException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public EmailAlreadyExistsException() {
		super("E-mail is already in use.");
	}
}
