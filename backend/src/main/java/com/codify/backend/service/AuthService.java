package com.codify.backend.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import com.codify.backend.dto.LoginRequest;
import com.codify.backend.exceptions.InvalidUsernameOrPasswordException;

@Service
public class AuthService {
	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;
	
	public AuthService(AuthenticationManager authenticationManager, JwtService jwtService) {
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
	}
	
	public LoginRequest trimRequest(LoginRequest request) {
		return new LoginRequest(
				request.username().trim(),
				request.password()		
			);
	}
	
	public String loginUser(LoginRequest request) {
		Authentication authentication;
		
		request = this.trimRequest(request);	
		
		try {
			authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));
		} catch (BadCredentialsException e) {
			throw new InvalidUsernameOrPasswordException();
		}
		
		return jwtService.generateToken(authentication);
	}
}
