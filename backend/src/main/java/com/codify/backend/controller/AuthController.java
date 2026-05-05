package com.codify.backend.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.codify.backend.dto.RegistrationRequest;
import com.codify.backend.dto.RegistrationResponse;
import com.codify.backend.mapper.UserAuthDtoMapper;
import com.codify.backend.model.User;
import com.codify.backend.service.AuthService;
import com.codify.backend.dto.LoginRequest;
import com.codify.backend.dto.LoginResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private final AuthService authService;
	private final UserAuthDtoMapper mapper;
	
	public AuthController(AuthService authService, UserAuthDtoMapper mapper) {
		this.authService = authService;
		this.mapper = mapper;
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest request) {
		String token = authService.loginUser(request);
		ResponseCookie cookie = ResponseCookie.from("jwt", token)
				.httpOnly(true)
				.secure(true)
				.path("/")
				.maxAge(24 * 60 * 60)
				.sameSite("Strict")
				.build();
		return ResponseEntity.ok()
				.header(HttpHeaders.SET_COOKIE, cookie.toString())
				.build();
	}
	
	@PostMapping("/register")
	public ResponseEntity<RegistrationResponse> registerUser(@RequestBody RegistrationRequest request) {
		User user = authService.register(request);
		return ResponseEntity.ok(mapper.toRegistrationResponse(user));
	}
}