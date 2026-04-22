package com.codify.backend.dto;

import com.codify.backend.enums.Status;
import java.time.LocalDate;

public record JobApplicationResponse(
	String positionTitle,
	String company,
	int salary,
	String jobListingURL,
	Status status,
	LocalDate dateApplied
	){}