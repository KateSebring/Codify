package com.codify.backend.dto;

import java.util.Set;

public record LoginRequest(
	String username,
	String password,
	Set<String> roles
){}
