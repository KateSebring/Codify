package com.codify.backend.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.codify.backend.dto.RegistrationRequest;
import com.codify.backend.dto.RegistrationResponse;
import com.codify.backend.mapper.UserAuthDtoMapper;
import com.codify.backend.model.User;
import com.codify.backend.model.UserPrincipal;
import com.codify.backend.service.AuthResult;
import com.codify.backend.service.AuthService;

import jakarta.servlet.http.HttpServletRequest;

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
				.sameSite("None")
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
	
	@GetMapping("/checkAuth")
	public ResponseEntity<AuthResult> getCurrentUser(Authentication authentication) {		
		if(authentication == null || !authentication.isAuthenticated()) {
			return ResponseEntity.ok(new AuthResult(null));
		}
		
		UserPrincipal user = (UserPrincipal) authentication.getPrincipal();
		return ResponseEntity.ok(new AuthResult(user.getUsername()));
	}
}