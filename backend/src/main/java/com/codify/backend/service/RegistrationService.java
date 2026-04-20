package com.codify.backend.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codify.backend.dto.RegistrationRequest;
import com.codify.backend.model.User;
import com.codify.backend.repository.UserRepository;
@Service
public class RegistrationService {
	private final PasswordEncoder passwordEncoder;
	private final UserRepository repo;
	public RegistrationService(UserRepository registrationRepository, PasswordEncoder passwordEncoder) {
		this.repo = registrationRepository;
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
	
	public User initializeUser(RegistrationRequest request) {
		User user = new User();
		user.setFirstName(request.firstName());
		user.setLastName(request.lastName());
		user.setEmail(request.email());
		user.setDob(request.dob());
		user.setUsername(request.username());
		user.setPasswordHash(passwordEncoder.encode(request.password()));
		
		return user;
	}
	
	public User register(RegistrationRequest request) throws Exception {
		request = this.trimRequest(request);
		
		if(repo.existsByEmail(request.email()) || repo.existsByUsername(request.username())) {
			throw new Exception("Error: Username or email already exists.");
		}
		
		if(this.hasEmptyField(request)) {
			throw new Exception("Error: empty field.");
		}
		
		return repo.save(initializeUser(request));
	}
}
