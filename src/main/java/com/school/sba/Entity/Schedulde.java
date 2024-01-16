package com.school.sba.entity;

import java.time.LocalTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Schedulde {
	@Id
	private int scheduldeId;
	private LocalTime opensAt;
	private LocalTime closesAt;
	private int classHoursPerDay;
	private LocalTime breakTime;
	private LocalTime breakLength;
	private LocalTime launchTime;
	private LocalTime lunchLength;

}
