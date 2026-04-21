package com.codify.backend.dto;

public record LoginResponse(
	String username,
	String token
){}