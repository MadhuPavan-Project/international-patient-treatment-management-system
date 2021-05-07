package com.cts.offerings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.offerings.client.AuthClient;
import com.cts.offerings.exception.InvalidTokenException;
import com.cts.offerings.model.IPTreatmentPackage;
import com.cts.offerings.model.SpecialistDetail;
import com.cts.offerings.service.IPTreatmentPackageService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class IPTreatmentPackageController {

	@Autowired
	IPTreatmentPackageService iPTreatmentPackageService;
	@Autowired
	AuthClient authClient;

	/**
	 * to get all treatment plans
	 */
	@GetMapping("/IPTreatmentPackages")
	public List<IPTreatmentPackage> getAllIPTreatmentPackages(@RequestHeader(name = "Authorization") String token)
			throws InvalidTokenException {
		log.info("Returning list of  All packages");
		boolean authResponse = authClient.verifyToken(token);
		if (authResponse) {
			return iPTreatmentPackageService.getIPTreatmentPackages();
		} else {
			throw new InvalidTokenException();
		}
	}

	/**
	 * to get cost of the treatment by package name and ailment category.
	 */
	@GetMapping("/IPTreatmentCost/{ailment}/{packageName}")
	public double getCostForIPTreatment(@PathVariable String ailment, @PathVariable String packageName,
			@RequestHeader(name = "Authorization") String token) throws InvalidTokenException {
		log.info("Returning Treatment cost By ailment and PackageName");
		boolean authResponse = authClient.verifyToken(token);
		if (authResponse) {
			return iPTreatmentPackageService.getCostforIpTreatmentPackages(ailment, packageName);
		} else {
			throw new InvalidTokenException();
		}
	}

	/**
	 * to get treatments by package name.
	 */
	@GetMapping("/IPTreatmentPackagesByName/{ailment}/{packageName}")
	public IPTreatmentPackage getTreatmentPackageByNameAndAilment(@PathVariable String ailment,
			@PathVariable String packageName, @RequestHeader(name = "Authorization") String token)
			throws InvalidTokenException {
		boolean authResponse = authClient.verifyToken(token);
		log.info("Returning Treatment Package By ailment and PackageName");
		if (authResponse) {
			return iPTreatmentPackageService.getTreatmentPackages(ailment, packageName);
		} else {
			throw new InvalidTokenException();
		}
	}

	/**
	 * to get all the specialists available in the hospital
	 */
	@GetMapping("/Specialists")
	public List<SpecialistDetail> getAllSpecialists(@RequestHeader(name = "Authorization") String token)
			throws InvalidTokenException {
		boolean authResponse = authClient.verifyToken(token);
		log.info("Returning list of Specialists");
		if (authResponse) {
			return iPTreatmentPackageService.getSpecialist();
		} else {
			throw new InvalidTokenException();
		}
	}

}
