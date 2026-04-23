package com.codify.backend.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.codify.backend.dto.JobApplicationRequest;
import com.codify.backend.model.JobApplication;
import com.codify.backend.repository.JobApplicationRepository;
import com.codify.backend.repository.UserRepository;
import com.codify.backend.model.User;

@Service
public class JobApplicationService {
	UserRepository userRepository;
	JobApplicationRepository jobApplicationRepository;
	
	public JobApplicationService(JobApplicationRepository jobApplicationRepository, UserRepository userRepository) {
		this.jobApplicationRepository = jobApplicationRepository;
		this.userRepository = userRepository;
	}
	
	public User getCurrentUser(Authentication authentication) throws Exception {
		UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
		return userRepository
				.findByUsername(userPrincipal.getUsername())
				.orElseThrow(() -> new Exception("User not found."));
	}

	public JobApplication getJobApplication(int id, Authentication authentication) throws Exception {
		User user = getCurrentUser(authentication);
		return  jobApplicationRepository
				.findByIdAndUserId(id, user.getUserId())
				.orElseThrow(() -> new Exception("Job application not found."));
	}
	
	public List<JobApplication> getAllJobApplications(Authentication authentication) throws Exception {
		User user = getCurrentUser(authentication);
		return jobApplicationRepository.findAllByUserId(user.getUserId());
	}
	
	public JobApplication createJobApplication(JobApplicationRequest jobApplicationRequest, Authentication authentication) throws Exception {
		User user = getCurrentUser(authentication);
		JobApplication jobApplication = new JobApplication(
				jobApplicationRequest.positionTitle(),
				jobApplicationRequest.company(),
				jobApplicationRequest.salary(),
				jobApplicationRequest.jobListingURL(),
				jobApplicationRequest.status(),
				jobApplicationRequest.dateApplied(),
				user);
		return jobApplicationRepository.save(jobApplication);
	}
	
	public JobApplication updateJobApplication(JobApplication updatedJobApplication) throws Exception {
		JobApplication jobApplication = jobApplicationRepository
				.findById(updatedJobApplication
						.getJobAppId())
				.orElseThrow(() -> new Exception("Job application not found."));
		
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
