package com.school.sba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.school.sba.Entity.School;

@SpringBootApplication (scanBasePackages = "com.school.sba")
public class SchoolBoardApiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SchoolBoardApiApplication.class, args);
		run.getBean(School.class);
	}

}
