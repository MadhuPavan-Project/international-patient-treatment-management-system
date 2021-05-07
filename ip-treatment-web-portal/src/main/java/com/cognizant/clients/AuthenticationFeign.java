package com.cognizant.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.model.Admin;

/**
 * Feign provides an abstraction over REST-based calls via annotation, by which
 * microservices can use to communicate with each other without writing detailed
 * REST client code
 */
@FeignClient(name = "AUTH", url = "http://localhost:8083/auth")
public interface AuthenticationFeign {
	/**
	 * to allow a user with valid Credentials to login into the app and access the
	 * functionalities.
	 */
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody Admin userlogincredentials);

	/**
	 * to verify the token that the user request is valid
	 */
	@GetMapping(value = "/validate")
	public boolean verifyToken(@RequestHeader("Authorization") String token);
}
