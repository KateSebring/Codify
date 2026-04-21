package com.codify.backend.dto;

import java.util.Set;

public record LoginResponse(
	String username,
	Set<String> role,
	String token
){}