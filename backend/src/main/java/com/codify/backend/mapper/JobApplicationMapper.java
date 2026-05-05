package com.codify.backend.mapper;

import org.springframework.stereotype.Component;

import com.codify.backend.dto.JobApplicationRequest;
import com.codify.backend.dto.JobApplicationResponse;
import com.codify.backend.model.JobApplication;
import com.codify.backend.model.User;

@Component
public class JobApplicationMapper {
	private String clean(String value) {
	    return value == null ? null : value.trim();
	}
	
	public JobApplication toJobApplication(JobApplicationRequest request, User user) {
		return new JobApplication(
				clean(request.positionTitle()),
				clean(request.company()),
				request.salary(),
				clean(request.jobListingURL()),
				request.status(),
				request.dateApplied(),
				user
			);
	}
	
	public JobApplicationResponse toJobApplicationDto(JobApplication jobApplication) {
		return new JobApplicationResponse(
				jobApplication.getPositionTitle(),
				jobApplication.getCompany(),
				jobApplication.getSalary(),
				jobApplication.getJobListingURL(),
				jobApplication.getStatus(),
				jobApplication.getDateApplied()
			);
	}
	
	public void toUpdatedJobApplication(JobApplication jobApplication, JobApplicationRequest request, User user) {
		jobApplication.setCompany(request.company());
		jobApplication.setDateApplied(request.dateApplied());
		jobApplication.setJobListingURL(request.jobListingURL());
		jobApplication.setPositionTitle(request.positionTitle());
		jobApplication.setSalary(request.salary());
		jobApplication.setStatus(request.status());
		jobApplication.setUser(user);
	}
}