package com.school.sba.utility;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class ApplicationDocumentation {
	
	Contact contact() {
		return new Contact().name("N S Santosh Kumar")
				.url("")
				.email("");
	}
	
	Info info() {
		return new Info().title("School Board - Intermediate level School Schedule Management Application")
				.version("1.0v")
				.description(" defining the school board schedulde using springboot  and spring security ");
	}
	
	@Bean
	OpenAPI openAPI() {
		return new OpenAPI().info(info());
		
	}
	

}
