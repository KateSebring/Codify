package com.codify.backend.service;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.codify.backend.model.JobApplication;
import com.codify.backend.repository.JobApplicationRepository;
import com.codify.backend.repository.UserRepository;
import com.codify.backend.model.User;

@Service
public class JobApplicationService {
	UserRepository userRepository;
	JobApplicationRepository jobApplicationRepository;
	
	public User verifyAuth(Authentication authentication) throws Exception {
		UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
		User user = userRepository
				.findByUsername(userPrincipal.getUsername())
				.orElseThrow(() -> new Exception("User not found."));
		return user;
	}
	
	public JobApplicationService(JobApplicationRepository jobApplicationRepository, UserRepository userRepository) {
		this.jobApplicationRepository = jobApplicationRepository;
		this.userRepository = userRepository;
	}

	public JobApplication getJobApplication(int id) throws Exception {
		return jobApplicationRepository
				.findById(id)
				.orElseThrow(() -> new Exception("Job application not found."));
	}
	
	public List<JobApplication> getAllJobApplications(Authentication authentication) throws Exception {
		User user = verifyAuth(authentication);
		List<JobApplication> userJobApplications = jobApplicationRepository.findAllByUserId(user.getUserId());
		return userJobApplications;
	}
	
	public JobApplication createJobApplication(JobApplication jobApplication) {
		return jobApplicationRepository.save(jobApplication);
	}
	
	public JobApplication updateJobApplication(JobApplication updatedJobApplication) {
		JobApplication jobApplication = jobApplicationRepository.findById(updatedJobApplication.getJobAppId()).orElseThrow();
		
		jobApplication.setCompany(updatedJobApplication.getCompany());
		jobApplication.setDateApplied(updatedJobApplication.getDateApplied());
		jobApplication.setJobListingURL(updatedJobApplication.getJobListingURL());
		jobApplication.setPositionTitle(updatedJobApplication.getPositionTitle());
		jobApplication.setSalary(updatedJobApplication.getSalary());
		jobApplication.setStatus(updatedJobApplication.getStatus());
		
		return jobApplicationRepository.save(jobApplication);
	}
	
	public void deleteJobApplication(int id, Authentication authentication)  {
		jobApplicationRepository.deleteById(id);
	}
}
