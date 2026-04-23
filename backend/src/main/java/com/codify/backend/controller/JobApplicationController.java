package com.codify.backend.controller;

import com.codify.backend.service.JobApplicationService;
import com.codify.backend.dto.JobApplicationRequest;
import com.codify.backend.dto.JobApplicationResponse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.codify.backend.model.JobApplication;

@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {
	private final JobApplicationService jobApplicationService;
	
	public JobApplicationController(JobApplicationService jobApplicationService) {
		this.jobApplicationService = jobApplicationService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<JobApplicationResponse> getJobApplication(@RequestBody int id, Authentication authentication) throws Exception {
		JobApplication jobApplication = jobApplicationService.getJobApplication(id, authentication);
		
		return ResponseEntity.ok(new JobApplicationResponse(
				jobApplication.getPositionTitle(),
				jobApplication.getCompany(),
				jobApplication.getSalary(),
				jobApplication.getJobListingURL(),
				jobApplication.getStatus(),
				jobApplication.getDateApplied()
			));
	}
	
	@GetMapping
	public ResponseEntity<List<JobApplicationResponse>> getAllJobApplications(@RequestBody Authentication authentication) throws Exception {
		List<JobApplication> jobApplications = jobApplicationService.getAllJobApplications(authentication);
		// TODO: replace this with a mapping helper class
		List<JobApplicationResponse> jobApplicationResponses = new ArrayList<JobApplicationResponse>();
		for(JobApplication jobApplication : jobApplications) {
			JobApplicationResponse jobApplicationResponse = new JobApplicationResponse(
					jobApplication.getPositionTitle(),
					jobApplication.getCompany(),
					jobApplication.getSalary(),
					jobApplication.getJobListingURL(),
					jobApplication.getStatus(),
					jobApplication.getDateApplied());
			jobApplicationResponses.add(jobApplicationResponse);
		}
		return ResponseEntity.ok(jobApplicationResponses);
	}
	
	@PostMapping
	public ResponseEntity<JobApplicationResponse> createJobApplication(@RequestBody JobApplicationRequest request, Authentication authentication) throws Exception {
		JobApplication jobApplication = jobApplicationService.createJobApplication(request, authentication);
		JobApplicationResponse jobApplicationResponse = new JobApplicationResponse(
				jobApplication.getPositionTitle(),
				jobApplication.getCompany(),
				jobApplication.getSalary(),
				jobApplication.getJobListingURL(),
				jobApplication.getStatus(),
				jobApplication.getDateApplied());
		return ResponseEntity.ok(jobApplicationResponse);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<JobApplicationResponse> updateJobApplication(@RequestBody JobApplicationRequest request) {
		// use mapper to pass in jobapplication object
		// JobApplication jobApp = mapper.toJobApplication(request);
		// jobApplicationService.updateJobApplication(jobApp);
		return ResponseEntity.ok(null);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteJobApplication(@RequestBody int id, Authentication authentication) {
		jobApplicationService.deleteJobApplication(id, authentication);
		return ResponseEntity.noContent().build();
	}
}
