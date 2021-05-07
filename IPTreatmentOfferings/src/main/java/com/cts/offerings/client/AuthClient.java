package com.cts.offerings.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**

 * @FeignClient provides an abstraction over REST-based calls via annotation, by which
 * microservices can communicate with each other without writing detailed REST
 * client code.
 */
@FeignClient(url = "localhost:8083/auth", name = "AUTH")
public interface AuthClient {

	/**
	 * to verify the token that the user request is valid
	 *
	 */
	@GetMapping(path = "/validate")
	public boolean verifyToken(@RequestHeader(name = "Authorization", required = true) String token);

}
