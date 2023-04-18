package com.basicsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class BasicSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicSystemApplication.class, args);
	}

}
