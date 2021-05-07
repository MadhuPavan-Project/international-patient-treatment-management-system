package com.cts.insuranceclaim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.insuranceclaim.Client.AuthClient;
import com.cts.insuranceclaim.exception.InvalidTokenException;
import com.cts.insuranceclaim.model.InitiateClaim;
import com.cts.insuranceclaim.model.InsurerDetail;
import com.cts.insuranceclaim.service.InsuranceClaimService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ICMicroserviceController {

	@Autowired
	InsuranceClaimService insuranceClaimService;

	@Autowired
	AuthClient authClient;

	/**
	 * 
	 * to get the list of insurers available for the patients only after verifying
	 * that the user trying to use this service is authenticated or not
	 *
	 */
	@GetMapping("/getAllInsurerDetails")
	public List<InsurerDetail> getAllInsurerDetails(@RequestHeader(name = "Authorization") String token)
			throws InvalidTokenException {

		boolean response = authClient.verifyToken(token);
		log.info("Returning List of Insurer Details");
		if (response) {
			return insuranceClaimService.getAllInsurerDetails();
		} else {
			throw new InvalidTokenException();
		}

	}

	/**
	 * return the insurer details by package name
	 */
	@GetMapping("/getInsurerByPackageName/{packageName}")
	public InsurerDetail getInsurerByPackageName(@PathVariable String packageName,
			@RequestHeader(name = "Authorization") String token) throws InvalidTokenException {
		boolean response = authClient.verifyToken(token);
		log.info("Returning Insurer Details By PackageName");
		if (response) {
			return insuranceClaimService.getInsurerByPackageName(packageName);
		} else {
			throw new InvalidTokenException();
		}

	}

	/**
	 * initiates claim for insurance of a patient whose current status is "In
	 * Progress" by providing claim details only after verifying that the user
	 * trying to use this service is authenticated or not
	 */
	@PostMapping("/initiateClaim")
	double getInitiateCliam(@RequestBody InitiateClaim initiateClaim,
			@RequestHeader(name = "Authorization") String token) throws InvalidTokenException {
		boolean response = authClient.verifyToken(token);
		log.info("Initiating the claim");
		if (response) {
			return insuranceClaimService.getInitiateClaim(initiateClaim, token);
		} else {
			throw new InvalidTokenException();
		}

	}

}
