package com.codify.backend.mapper;

import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.codify.backend.dto.LoginRequest;
import com.codify.backend.dto.LoginResponse;
import com.codify.backend.dto.RegistrationRequest;
import com.codify.backend.dto.RegistrationResponse;
import com.codify.backend.model.User;

public class UserAuthDtoMapper {
	private String clean(String value) {
	    return value == null ? null : value.trim();
	}
	
	public User toUser(RegistrationRequest request, PasswordEncoder encoder) {
		return new User(
				clean(request.username()),
				encoder.encode(request.password()),
				clean(request.firstName()),
				clean(request.lastName()),
				request.dob(),
				clean(request.email())
			);
	}
	
	public RegistrationResponse toRegistrationDto(User user) {
		return new RegistrationResponse(
				user.getUsername(),
				user.getRoles().stream()
				    .map(Enum::name)
				    .collect(Collectors.toSet())
			);
	}
	
	public LoginResponse toLoginDto(String token, LoginRequest request) {
		return new LoginResponse(
				request.username().trim(),
				token
			);
	}
}