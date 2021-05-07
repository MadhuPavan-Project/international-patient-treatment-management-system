package com.cognizant.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.model.InitiateClaim;
import com.cognizant.model.InsurerDetail;

/**
 * Feign provides an abstraction over REST-based calls via annotation,
 * by which microservices can use to communicate with each other without
 * writing detailed REST client code 
 */
@FeignClient(url = "http://localhost:8084", name = "insurance-claim-microservice")
public interface ICClient {

	/**
	 * get all of the available Insurance Providers.
	 */
	@GetMapping("/getAllInsurerDetails")
	public List<InsurerDetail> getAllInsurerDetails(@RequestHeader("Authorization") String token);

	/**
	 * get all of the available Insurance Providers by package name.
	 */
	@GetMapping("/getInsurerByPackageName/{packageName}")
	public InsurerDetail getInsurerByPackageName(@PathVariable String packageName,
			@RequestHeader("Authorization") String token);

	/**
	 * get the details of the Insured Patient by patient id.
	 */
	@RequestMapping(value = "/getinsuredpatient/{patientId}", method = RequestMethod.GET)
	public InitiateClaim getInsurerdPatient(@RequestHeader("Authorization") String token, @PathVariable long patientId);

	/**
	 * return the balance amount to be paid by patient
	 */
	@RequestMapping(value = "/initiateClaim", method = RequestMethod.POST)
	public double getInitiateCliam(@RequestBody InitiateClaim initiateClaim,
			@RequestHeader("Authorization") String token);
}
