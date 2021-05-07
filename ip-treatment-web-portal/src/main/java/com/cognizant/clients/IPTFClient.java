package com.cognizant.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import com.cognizant.model.PatientDetail;
import com.cognizant.model.TreatmentPlan;

/**
 * Feign provides an abstraction over REST-based calls via annotation, by which
 * microservices can use to communicate with each other without writing detailed
 * REST client code
 */
@FeignClient(url = "http://localhost:8082/iptms", name = "iptms-treatments-microservice")
public interface IPTFClient {

	/**
	 * create the TimeTable for a patient according to a Particular Treatment.
	 */
	@PostMapping(value = "/formulatetreatmenttimetable")
	public TreatmentPlan getTreatmentTimetable(@RequestBody PatientDetail patientDetail,
			@RequestHeader("Authorization") String token);

	/**
	 * return a patient based on patient Id.
	 */
	@GetMapping("/getpatient/{ptId}")
	public PatientDetail getPatient(@PathVariable long ptId, @RequestHeader("Authorization") String token);

	/**
	 * return All the Patients Treatment Plan.
	 */
	@GetMapping("/getallpatients")
	public List<TreatmentPlan> getAllPatients(@RequestHeader("Authorization") String token);

	/**
	 * return All the Patients Whose Treatment is currently Going On.
	 */
	@GetMapping("/getallongoingtreatments")
	public List<TreatmentPlan> getAllOnGoingTreatments(@RequestHeader("Authorization") String token);

	/**
	 * return the treatment plan for a particular user based on PateintId
	 */
	@GetMapping("/getplan/{ptId}")
	public TreatmentPlan getAPlan(@PathVariable long ptId, @RequestHeader("Authorization") String token);

	/**
	 * update the patient Status from In-Progress to Complete.
	 */
	@PutMapping("/updateplan/{pId}")
	public void updatePlan(@PathVariable long pId, @RequestHeader("Authorization") String token);
}
