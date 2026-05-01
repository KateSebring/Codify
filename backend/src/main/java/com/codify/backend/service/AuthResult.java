package com.codify.backend.service;

import com.codify.backend.model.User;

public record AuthResult(
	User user,
	String token
){}