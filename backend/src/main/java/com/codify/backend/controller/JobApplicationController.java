package com.codify.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.codify.backend.model.JobApplication;
@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {
	// TODO: add authentication as required parameter for each mapping
	// TODO: add return of JobApplicationResponse as needed

	@GetMapping("/{id}")
	public JobApplication getJobApplication(int id) {
		return null;
	}
	
	@GetMapping
	public List<JobApplication> getAllJobApplications() {
		return null;
	}
	
	@PutMapping("/{id}")
	public void editJobApplication(int id) {
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteJobApplication(int id) {
		
	}
	
	// TODO: needs to take in JobApplicationRequest
	@PostMapping
	public void createJobApplication() {
		
	}
}
