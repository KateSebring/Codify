package com.codify.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codify.backend.model.JobApplication;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer> {
	Optional<JobApplication> findById(int id);
	
	void deleteById(int id);
}