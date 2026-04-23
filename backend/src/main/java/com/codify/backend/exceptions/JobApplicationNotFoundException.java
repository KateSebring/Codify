package com.codify.backend.exceptions;

public class JobApplicationNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public JobApplicationNotFoundException() {
		super("Job application not found.");
	}
}
