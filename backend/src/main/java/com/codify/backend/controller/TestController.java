package com.codify.backend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TestController {

	@GetMapping
	public String home() {
		return "<h1>Welcome, user!</h1>";
	}
	
	@GetMapping("/authorized")
	public String auth() {
		return "<h1>Successfuly authorized</h1>";
	}
}
