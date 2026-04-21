package com.codify.backend.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codify.backend.dto.LoginRequest;
import com.codify.backend.model.User;
import com.codify.backend.repository.UserRepository;

@Service
public class AuthService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	
	public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.authenticationManager = authenticationManager;
	}
	
	public LoginRequest trimRequest(LoginRequest request) {
		return new LoginRequest(
				request.username().trim(),
				request.password(),
				request.roles()
		);
	}
	
	public String loginUser(LoginRequest request) throws BadCredentialsException {
		request = this.trimRequest(request);		
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));
		
		if(authentication.isAuthenticated()) {
			return "Success!";
		}
		
		return "Failure :(";
	}
}
