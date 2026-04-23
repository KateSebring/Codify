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
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	public JobApplication(String positionTitle, String company, int salary, String jobListingURL, Status status, LocalDate dateApplied, User user) {
		this.positionTitle = positionTitle;
		this.company = company;
		this.salary = salary;
		this.jobListingURL = jobListingURL;
		this.status = status;
		this.dateApplied = dateApplied;
		this.user = user;
	}
}