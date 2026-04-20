package com.codify.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest request) {
		return ResponseEntity.ok(null);
	}
}