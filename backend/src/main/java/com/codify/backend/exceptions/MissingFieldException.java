package com.codify.backend.exceptions;

public class MissingFieldException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public MissingFieldException() {
		super("Empty field in form.");
	}
}
