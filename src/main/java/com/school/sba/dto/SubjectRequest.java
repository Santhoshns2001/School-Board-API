package com.school.sba.dto;

import java.util.List;

import com.school.sba.entity.Subject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class SubjectRequest {
	
	private List<Subject> subjects;

}
