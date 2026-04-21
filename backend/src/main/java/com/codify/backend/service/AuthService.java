package com.codify.backend.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codify.backend.dto.LoginRequest;
import com.codify.backend.dto.RegistrationRequest;
import com.codify.backend.model.User;
import com.codify.backend.repository.UserRepository;

@Service
public class AuthService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public LoginRequest trimRequest(LoginRequest request) {
		return new LoginRequest(
				request.username().trim(),
				request.password()
		);
	}
	
	public String loginUser(LoginRequest request) throws Exception {
		request = this.trimRequest(request);		
		User foundUser = userRepository.findByUsername(
				request.username())
				.orElseThrow(() -> 
				new Exception("Username or password was incorrect.")
			);
		
		if(!passwordEncoder.matches(request.password(), foundUser.getPasswordHash())) {
			throw new Exception("Username or password was incorrect.");
		}
		
		return "token-goes-here-whoo";
	}
}
