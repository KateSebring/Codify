package com.codify.backend.controller;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.codify.backend.dto.LoginResponse;
import com.codify.backend.service.AuthService;
import com.codify.backend.dto.LoginRequest;

@RestController
@RequestMapping("/api/login")
public class LoginController {
	private final AuthService authService;
	
	public LoginController(AuthService authService) {
		this.authService = authService;
	}
	
	@PostMapping
	public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest request) throws Exception {
		String token = authService.loginUser(request);
		Set<String> userRoleSet = request.roles().stream()
				.map(role -> "ROLE_" + role)
				.collect(Collectors.toSet());
		
		LoginResponse response = new LoginResponse(
				request.username().trim(),
				userRoleSet,
				token);
		return ResponseEntity.ok(response);
	}
}