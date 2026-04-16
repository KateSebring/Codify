package com.codify.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.codify.backend.model.JobApplication;
import com.codify.backend.repository.JobApplicationRepository;

@Service
public class JobApplicationService {

	JobApplicationRepository jobApplicationRepository;
	
	public JobApplicationService(JobApplicationRepository jobApplicationRepository) {
		this.jobApplicationRepository = jobApplicationRepository;
	}

	public JobApplication getJobApplication(int id) {
		return jobApplicationRepository.findById(id).orElseThrow();
	}
	
	public List<JobApplication> getAllJobApplications() {
		return jobApplicationRepository.findAll();
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
	
	public void deleteJobApplication(int id) {
		jobApplicationRepository.deleteById(id);
	}
}
