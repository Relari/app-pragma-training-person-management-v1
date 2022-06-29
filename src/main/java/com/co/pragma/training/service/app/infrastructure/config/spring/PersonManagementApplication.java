package com.co.pragma.training.service.app.infrastructure.config.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.co.pragma.training.service.app.infrastructure")
public class PersonManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonManagementApplication.class, args);
	}

}
