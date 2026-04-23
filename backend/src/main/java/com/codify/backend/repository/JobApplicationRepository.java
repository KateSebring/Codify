package com.codify.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codify.backend.model.JobApplication;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer> {
	Optional<JobApplication> findByIdAndUserId(int id, int userId);
	List<JobApplication> findAllByUserId(int userId);
	void deleteById(int id);
}