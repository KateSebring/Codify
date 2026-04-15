package com.codify.backend.model;

import com.codify.backend.enums.Status;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobAppId;
	private String positionTitle;
	private String company;
	private int salary;
	private String jobListingURL;
	@Enumerated(EnumType.STRING)
	private Status status;
	private LocalDate dateApplied;
}