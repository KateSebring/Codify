package com.codify.backend.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import com.codify.backend.dto.LoginRequest;

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
	
	public String loginUser(LoginRequest request) throws BadCredentialsException {
		request = this.trimRequest(request);		
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));
		
		return jwtService.generateToken(authentication);
	}
}
