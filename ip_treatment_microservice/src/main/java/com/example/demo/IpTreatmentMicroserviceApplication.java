package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 		@SpringBootApplication is used in our application or main class to enable a
 *      host of features, e.g. Java-based Spring configuration, 
 *      component scanning, and in particular for enabling 
 *      Spring Boot's auto-configuration feature.
 * 		@EnableFeignClients scans for interfaces that declare they are 
 * 		feign clients (via @FeignClient )
 *
 */
@SpringBootApplication
@EnableFeignClients
public class IpTreatmentMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpTreatmentMicroserviceApplication.class, args);
	}

}
