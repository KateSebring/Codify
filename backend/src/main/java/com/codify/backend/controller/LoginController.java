package com.codify.backend.controller;

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
		LoginResponse response = new LoginResponse(
				request.username().trim(),
				"USER",
				token);
		return ResponseEntity.ok(response);
	}
}