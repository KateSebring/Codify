package com.codify.backend.exceptions;

public class InvalidUsernameOrPasswordException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public InvalidUsernameOrPasswordException() {
		super("Invalid username and/or password.");
	}
}