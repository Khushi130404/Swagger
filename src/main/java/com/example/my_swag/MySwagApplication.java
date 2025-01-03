package com.example.my_swag;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class MySwagApplication {
	public static void main(String[] args) {
		SpringApplication.run(MySwagApplication.class, args);
		System.out.println("my_swag");
	}
}
