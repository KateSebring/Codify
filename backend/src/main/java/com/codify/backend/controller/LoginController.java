package com.codify.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.codify.backend.dto.LoginResponse;
import com.codify.backend.dto.LoginRequest;

@RestController
@RequestMapping("/api/login")
public class LoginController {
	@PostMapping
	public ResponseEntity<LoginResponse> loginUser(LoginRequest request) {
		return ResponseEntity.ok(null);
	}
}