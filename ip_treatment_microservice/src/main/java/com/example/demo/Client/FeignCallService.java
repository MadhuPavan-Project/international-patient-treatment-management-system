package com.example.demo.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * 
 * @FeignClient provides an abstraction over REST-based calls via annotation, by
 *              which microservices can communicate with each other without
 *              writing detailed REST client code.
 */
@FeignClient(name = "iptms-treatments-microservice", url = "http://localhost:8081")
public interface FeignCallService {

	/**
	 * to get the cost of treatment of the package.
	 */
	@GetMapping("/IPTreatmentCost/{ailment}/{packageName}")
	public double getCostForIPTreatment(@PathVariable String ailment, @PathVariable String packageName,
			@RequestHeader("Authorization") String token);

}
