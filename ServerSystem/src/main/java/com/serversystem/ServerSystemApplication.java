package com.serversystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServerSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerSystemApplication.class, args);
	}

}
