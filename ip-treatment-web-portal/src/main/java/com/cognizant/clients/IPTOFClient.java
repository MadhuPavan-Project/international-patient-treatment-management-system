package com.cognizant.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.model.IPTreatmentPackage;
import com.cognizant.model.SpecialistDetail;

/**
 * Feign provides an abstraction over REST-based calls via annotation, by which
 * microservices can use to communicate with each other without writing detailed
 * REST client code
 */
@FeignClient(url = "http://localhost:8081", name = "ipt-offering-microservice")
public interface IPTOFClient {

	/**
	 * returns all the treatment packages available in hospital.
	 * 
	 * @param token
	 * @return
	 */
	@GetMapping("/IPTreatmentPackages")
	List<IPTreatmentPackage> getAllIPTreatmentPackages(@RequestHeader(name = "Authorization") String token);

	/**
	 * returns treatment plans by package name and ailment category.
	 * 
	 * @param category
	 * @param packageName
	 * @param token
	 * @return
	 */
	@RequestMapping(path = "/iptreatmentpackagebyname/{category}/{packageName}", method = RequestMethod.GET)
	ResponseEntity<?> getIPTreatmentPackageByAilmentCategoryAndName(@PathVariable String category,
			@PathVariable String packageName, @RequestHeader(name = "Authorization") String token);

	/**
	 * returns the list of Specialists available in hospital.
	 * 
	 * @param token
	 * @return
	 */
	@RequestMapping(path = "/Specialists", method = RequestMethod.GET)
	List<SpecialistDetail> getSpecialists(@RequestHeader(name = "Authorization") String token);
}
