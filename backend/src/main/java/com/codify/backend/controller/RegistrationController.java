package com.codify.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.codify.backend.dto.RegistrationRequest;
import com.codify.backend.dto.RegistrationResponse;

@RestController
@RequestMapping("/api/register")
public class RegistrationController {
	@PostMapping
	public ResponseEntity<RegistrationResponse> registerUser(RegistrationRequest request) {
		return ResponseEntity.ok(null);
	}
}