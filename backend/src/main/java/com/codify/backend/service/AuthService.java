package com.codify.backend.service;

import com.codify.backend.repository.UserRepository;
public class AuthService {
	UserRepository userRepository;
	
	public AuthService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	// public void loginUser()
}
