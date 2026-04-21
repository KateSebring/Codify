package com.codify.backend.dto;

import java.util.Set;

public record RegistrationResponse(
	String username, 
	Set<String> roles,
	String token
){}
