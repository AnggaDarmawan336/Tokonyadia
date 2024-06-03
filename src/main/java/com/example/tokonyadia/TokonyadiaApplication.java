package com.example.tokonyadia;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Tokonyadia CRUD REST API", version = "1.0.0", description = "Software or API documentation for Tokonyadia"))
public class TokonyadiaApplication {
	public static void main(String[] args) {
		SpringApplication.run(TokonyadiaApplication.class, args);
	}
}
