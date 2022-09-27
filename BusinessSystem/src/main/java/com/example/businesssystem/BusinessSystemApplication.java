package com.example.businesssystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BusinessSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessSystemApplication.class, args);
	}

}
