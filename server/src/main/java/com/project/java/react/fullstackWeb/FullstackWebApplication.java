package com.project.java.react.fullstackWeb;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Swagger ",version = "1.0",description = "Documentation APIs v1.0"))

@SpringBootApplication
public class FullstackWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullstackWebApplication.class, args);
	}

}
