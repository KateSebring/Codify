package com.codify.backend.controller;

import com.codify.backend.service.JobApplicationService;
import com.codify.backend.dto.JobApplicationRequest;
import com.codify.backend.dto.JobApplicationResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.codify.backend.model.JobApplication;

@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {
	private final JobApplicationService jobApplicationService;
	
	public JobApplicationController(JobApplicationService jobApplicationService) {
		this.jobApplicationService = jobApplicationService;
	}
	
	// TODO: add authentication as required parameter for each mapping
	@GetMapping("/{id}")
	public ResponseEntity<JobApplicationResponse> getJobApplication(@RequestBody int id) {
		return ResponseEntity.ok(null);
	}
	
	@GetMapping
	public ResponseEntity<List<JobApplication>> getAllJobApplications() {
		return ResponseEntity.ok(null);
	}
	
	@PostMapping
	public ResponseEntity<JobApplicationResponse> createJobApplication(@RequestBody JobApplicationRequest request) {
		// use mapper to pass in jobapplication object
		return ResponseEntity.ok(null);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<JobApplicationResponse> updateJobApplication(@RequestBody JobApplicationRequest request) {
		// use mapper to pass in jobapplication object
		// JobApplication jobApp = mapper.toJobApplication(request);
		// jobApplicationService.updateJobApplication(jobApp);
		return ResponseEntity.ok(null);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteJobApplication(@RequestBody int id) {
		return ResponseEntity.noContent().build();
	}
}
