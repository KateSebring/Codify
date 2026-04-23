package com.codify.backend.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codify.backend.dto.JobApplicationRequest;
import com.codify.backend.exceptions.JobApplicationNotFoundException;
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
	
	public User getCurrentUser(Authentication authentication) {
		UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
		return userRepository
				.findByUsername(userPrincipal.getUsername())
				.orElseThrow(() -> new UsernameNotFoundException("User not found."));
	}

	public JobApplication getJobApplication(int id, Authentication authentication) {
		User user = getCurrentUser(authentication);
		return  jobApplicationRepository
				.findByIdAndUserId(id, user.getUserId())
				.orElseThrow(JobApplicationNotFoundException::new);
	}
	
	public List<JobApplication> getAllJobApplications(Authentication authentication) {
		User user = getCurrentUser(authentication);
		return jobApplicationRepository.findAllByUserId(user.getUserId());
	}
	
	public JobApplication createJobApplication(JobApplicationRequest jobApplicationRequest, Authentication authentication) {
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
	
	public JobApplication updateJobApplication(int id, JobApplicationRequest updatedJobApplication, Authentication authentication) {
		User user = getCurrentUser(authentication);
		JobApplication jobApplication = jobApplicationRepository
				.findByIdAndUserId(id, user.getUserId())
				.orElseThrow(() -> new JobApplicationNotFoundException());
		
		jobApplication.setCompany(updatedJobApplication.company());
		jobApplication.setDateApplied(updatedJobApplication.dateApplied());
		jobApplication.setJobListingURL(updatedJobApplication.jobListingURL());
		jobApplication.setPositionTitle(updatedJobApplication.positionTitle());
		jobApplication.setSalary(updatedJobApplication.salary());
		jobApplication.setStatus(updatedJobApplication.status());
		jobApplication.setUser(user);
		
		return jobApplicationRepository.save(jobApplication);
	}
	
	public void deleteJobApplication(int id, Authentication authentication)  {
		User user = getCurrentUser(authentication);
		int deleted = jobApplicationRepository.deleteByIdAndUserId(id, user.getUserId());
		if(deleted == 0) {
			throw new JobApplicationNotFoundException();
		}
	}
}
