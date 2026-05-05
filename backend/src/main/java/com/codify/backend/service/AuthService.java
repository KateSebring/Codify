package com.codify.backend.service;

import java.util.Set;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codify.backend.dto.LoginRequest;
import com.codify.backend.dto.RegistrationRequest;
import com.codify.backend.enums.Role;
import com.codify.backend.exceptions.*;
import com.codify.backend.model.User;
import com.codify.backend.repository.UserRepository;

@Service
public class AuthService {
	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;
	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;
	
	public AuthService(AuthenticationManager authenticationManager, JwtService jwtService, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	/*
	 * LOGIN METHODS
	 */
	public LoginRequest trimLoginRequest(LoginRequest request) {
		return new LoginRequest(
				request.username().trim(),
				request.password()		
			);
	}
	
	public String loginUser(LoginRequest request) {
		Authentication authentication;
		
		request = this.trimLoginRequest(request);	
		
		try {
			authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));
		} catch (BadCredentialsException e) {
			throw new InvalidUsernameOrPasswordException();
		}
		
		return jwtService.generateToken(authentication);
	}
	
	/*
	 * REGISTRATION METHODS
	 */
	public RegistrationRequest trimRegistrationRequest(RegistrationRequest request) {
		return new RegistrationRequest(
				request.firstName().trim(),
				request.lastName().trim(),
				request.username().trim(),
				request.email().trim(),
				request.password(),
				request.dob()
		);
	}
	
	public boolean hasEmptyField(RegistrationRequest request) {
		if(
				request.firstName() == null || 
				request.firstName().isBlank() || 
				request.lastName() == null ||
				request.lastName().isBlank() ||
				request.username() == null ||
				request.username().isBlank() ||
				request.email() == null ||
				request.email().isBlank() ||
				request.password() == null ||
				request.password().isBlank() ||
				request.dob() == null
			) {
			return true;
		}
		return false;
	}
	
	public User initializeUser(RegistrationRequest request) {		
		User user = new User(
				request.username(),
				passwordEncoder.encode(request.password()),
				request.firstName(),
				request.lastName(),
				request.dob(),
				request.email()
				);
		
		user.setRoles(Set.of(Role.USER));
		
		return user;
	}
	
	public User register(RegistrationRequest request) {
		request = this.trimRegistrationRequest(request);
		
		if(userRepository.existsByEmail(request.email())) {
			throw new EmailAlreadyExistsException();
		} else if(userRepository.existsByUsername(request.username())) {
			throw new UsernameAlreadyExistsException();
		} else if (this.hasEmptyField(request)) {
			throw new MissingFieldException();
		}
		
		// use mapper to create new user
		// and then save it via userRepository
		return userRepository.save(initializeUser(request));
	}
}