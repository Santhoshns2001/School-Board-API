package com.school.sba.dto;


import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduldeResponse {
	
	private int scheduldeId;
	private LocalTime opensAt;
	private LocalTime closesAt;
	private int classHoursPerDay;
	private int classHoursLengthInMin;
	private LocalTime breakTime;
	private int breakLengthInMin;
	private LocalTime launchTime;
	private int lunchLengthInMin;

}
