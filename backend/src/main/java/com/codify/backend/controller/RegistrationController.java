package com.codify.backend.controller;

import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.codify.backend.dto.RegistrationRequest;
import com.codify.backend.dto.RegistrationResponse;
import com.codify.backend.model.User;
import com.codify.backend.service.RegistrationService;

@RestController
@RequestMapping("/api/register")
public class RegistrationController {
	private final RegistrationService registrationService;
	
	public RegistrationController(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}
	
	@PostMapping
	public ResponseEntity<RegistrationResponse> registerUser(@RequestBody RegistrationRequest request) {
		User user = registrationService.register(request);
		
		RegistrationResponse response = new RegistrationResponse(
				user.getUsername(),
				user.getRoles().stream()
				    .map(Enum::name)
				    .collect(Collectors.toSet())
			);
		
		return ResponseEntity.ok(response);
	}
}