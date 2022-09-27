package com.example.gatewaysystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class GatewaySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewaySystemApplication.class, args);
	}

}
