package com.codify.backend.service;

import org.springframework.stereotype.Service;

import com.codify.backend.repository.UserRepository;

@Service
public class AuthService {
	UserRepository userRepository;
	
	public AuthService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	// public void loginUser()
}
