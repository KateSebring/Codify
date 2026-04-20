package com.codify.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.codify.backend.dto.RegistrationRequest;
import com.codify.backend.dto.RegistrationResponse;
import com.codify.backend.service.RegistrationService;

@RestController
@RequestMapping("/api/register")
public class RegistrationController {
	private final RegistrationService registrationService;
	
	public RegistrationController(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}
	
	@PostMapping
	public ResponseEntity<RegistrationResponse> registerUser(@RequestBody RegistrationRequest request) throws Exception {
//		registrationService.register(request);
		return ResponseEntity.ok(null);
	}
}