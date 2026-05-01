package com.codify.backend.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codify.backend.dto.JobApplicationRequest;
import com.codify.backend.exceptions.JobApplicationNotFoundException;
import com.codify.backend.mapper.JobApplicationMapper;
import com.codify.backend.model.JobApplication;
import com.codify.backend.repository.JobApplicationRepository;
import com.codify.backend.repository.UserRepository;
import com.codify.backend.model.User;

@Service
public class JobApplicationService {
	UserRepository userRepository;
	JobApplicationRepository jobApplicationRepository;
	JobApplicationMapper jobApplicationMapper;
	
	public JobApplicationService(JobApplicationRepository jobApplicationRepository, UserRepository userRepository, JobApplicationMapper jobApplicationMapper) {
		this.jobApplicationRepository = jobApplicationRepository;
		this.userRepository = userRepository;
		this.jobApplicationMapper = jobApplicationMapper;
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
				.findByIdAndUserId(id, user.getId())
				.orElseThrow(JobApplicationNotFoundException::new);
	}
	
	public List<JobApplication> getAllJobApplications(Authentication authentication) {
		User user = getCurrentUser(authentication);
		return jobApplicationRepository.findAllByUserId(user.getId());
	}
	
	public JobApplication createJobApplication(JobApplicationRequest request, Authentication authentication) {
		User user = getCurrentUser(authentication);
		JobApplication jobApplication = jobApplicationMapper.toJobApplication(request, user);
		return jobApplicationRepository.save(jobApplication);
	}
	
	public JobApplication updateJobApplication(int id, JobApplicationRequest request, Authentication authentication) {
		User user = getCurrentUser(authentication);
		JobApplication jobApplication = jobApplicationRepository
				.findByIdAndUserId(id, user.getId())
				.orElseThrow((JobApplicationNotFoundException::new));
		
		jobApplicationMapper.toUpdatedJobApplication(jobApplication, request, user);
		
		return jobApplicationRepository.save(jobApplication);
	}
	
	public void deleteJobApplication(int id, Authentication authentication)  {
		User user = getCurrentUser(authentication);
		int deleted = jobApplicationRepository.deleteByIdAndUserId(id, user.getId());
		if(deleted == 0) {
			throw new JobApplicationNotFoundException();
		}
	}
}
