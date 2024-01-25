package com.school.sba.dto;

import java.time.LocalDate;

import com.school.sba.Enum.ClassStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassHourResponse {
	
	private int classHourId;
	private LocalDate beginsAt;
	private LocalDate endsAt;
	private int roomNo;
	private ClassStatus classStatus; 

}
