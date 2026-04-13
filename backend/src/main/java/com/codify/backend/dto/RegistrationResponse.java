package com.codify.backend.dto;

public record RegistrationResponse(
	String username, 
	String role,
	String token
){}
