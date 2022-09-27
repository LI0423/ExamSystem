package com.example.eurekasystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaSystemApplication.class, args);
    }

}
