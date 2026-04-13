package com.codify.backend.dto;

import java.time.LocalDate;

import com.codify.backend.Status;

public record JobApplicationResponse(
	String positionTitle,
	String company,
	int salary,
	String jobListingURL,
	Status status,
	LocalDate dateApplied,
	String token
){}