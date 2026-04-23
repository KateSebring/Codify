package com.codify.backend.service;

import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codify.backend.dto.RegistrationRequest;
import com.codify.backend.enums.Role;
import com.codify.backend.model.User;
import com.codify.backend.repository.UserRepository;
@Service
public class RegistrationService {
	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;
	public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public RegistrationRequest trimRequest(RegistrationRequest request) {
		return new RegistrationRequest(
				request.firstName().trim(),
				request.lastName().trim(),
				request.username().trim(),
				request.email().trim(),
				request.password(),
				request.dob()
		);
	}
	
	// ensures that no blank fields exist
	// form checks for empty fields but this acts as a second barrier
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
	
	// create a new user that will be saved
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
	
	public User register(RegistrationRequest request) throws Exception {
		request = this.trimRequest(request);
		
		if(userRepository.existsByEmail(request.email()) || userRepository.existsByUsername(request.username())) {
			throw new Exception("Error: Username or email already exists.");
		}
		
		if(this.hasEmptyField(request)) {
			throw new Exception("Error: empty field.");
		}
		
		return userRepository.save(initializeUser(request));
	}
}
