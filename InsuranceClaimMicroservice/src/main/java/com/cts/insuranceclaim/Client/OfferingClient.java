package com.cts.insuranceclaim.Client;

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
@FeignClient(name = "iptms-treaments-offerings-microservice", url = "http://localhost:8081")
public interface OfferingClient {

	/**
	 * to get the cost of the treatment for the package.
	 */
	@GetMapping("/IPTreatmentCost/{ailment}/{packageName}")
	double getCostForIPTreatment(@PathVariable String ailment, @PathVariable String packageName,
			@RequestHeader(name = "Authorization") String token);
}
