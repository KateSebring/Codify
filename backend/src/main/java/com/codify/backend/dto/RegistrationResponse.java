package com.codify.backend.dto;

import java.util.Set;

import com.codify.backend.enums.Role;

public record RegistrationResponse(
	String username, 
	Set<String> roles,
	String token
){}
