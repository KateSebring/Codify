package com.codify.backend.repository;

import org.springframework.data.repository.CrudRepository;
import com.codify.backend.model.JobApplication;

public interface JobApplicationRepository extends CrudRepository<JobApplication, Integer> {
	JobApplication findById(int id);
	
	void deleteById(int id);
}