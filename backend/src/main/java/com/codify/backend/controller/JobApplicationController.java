package com.codify.backend.controller;

import com.codify.backend.service.JobApplicationService;
import com.codify.backend.dto.JobApplicationRequest;
import com.codify.backend.dto.JobApplicationResponse;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.codify.backend.model.JobApplication;

@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {
	JobApplicationService jobApplicationService;
	
	public JobApplicationController (JobApplicationService jobApplicationService) {
		this.jobApplicationService = jobApplicationService;
	}
	
	// TODO: add authentication as required parameter for each mapping
	@GetMapping("/{id}")
	public ResponseEntity<JobApplicationResponse> getJobApplication(int id) {
		return ResponseEntity.ok(null);
	}
	
	@GetMapping
	public ResponseEntity<List<JobApplication>> getAllJobApplications() {
		return ResponseEntity.ok(null);
	}
	
	@PostMapping
	public ResponseEntity<JobApplicationResponse> createJobApplication(JobApplicationRequest request) {
		return ResponseEntity.ok(null);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<JobApplicationResponse> updateJobApplication(int id, JobApplicationRequest request) {
		return ResponseEntity.ok(null);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteJobApplication(int id) {
		return ResponseEntity.noContent().build();
	}
}
