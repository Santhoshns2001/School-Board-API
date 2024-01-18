package com.school.sba.entity;

import java.time.Duration;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Schedulde {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int scheduldeId;
	private LocalTime opensAt;
	private LocalTime closesAt;
	private int classHoursPerDay;
	private Duration classHoursLengthInMin;
	private LocalTime breakTime;
	private Duration breakLengthInMin;
	private LocalTime launchTime;
	private Duration lunchLengthInMin;
	
	@OneToOne(mappedBy = "scheduldeId")
	private School school;

}
