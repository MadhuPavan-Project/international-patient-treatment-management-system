package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Client.AuthClient;
import com.example.demo.Model.PatientDetail;
import com.example.demo.Model.TreatmentPlan;
import com.example.demo.Service.IPTreatmentServiceImpl;
import com.example.demo.exception.InvalidTokenException;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/iptms")
public class IPTreatmentController {

	@Autowired
	private IPTreatmentServiceImpl iptService;

	@Autowired
	private AuthClient authClient;

	/**
	 * to get the list of all the patients only after verifying that the user trying
	 * to use this service is authenticated or not
	 */
	@PostMapping(value = "/formulatetreatmenttimetable")
	public TreatmentPlan getTreatmentTimetable(@RequestBody PatientDetail patientDetail,
			@RequestHeader("Authorization") String token) throws InvalidTokenException {
		boolean response = authClient.verifyToken(token);
		log.info("Formulating a Treatment TimeTable for the patients");
		if (response)
			return iptService.getTreatmentPlan(patientDetail, token);
		else
			throw new InvalidTokenException();
	}

	/**
	 * to get the list of all the patients only after verifying that the user trying
	 * to use this service is authenticated or not
	 */
	@GetMapping(value = "/formulatetreatmenttimetable")
	public TreatmentPlan formulateTreatmentTimetable(@RequestBody PatientDetail patientDetail,
			@RequestHeader("Authorization") String token) throws InvalidTokenException {
		boolean response = authClient.verifyToken(token);
		log.info("Formulating a Treatment TimeTable for the patients");
		if (response)
			return iptService.getTreatmentPlan(patientDetail, token);     
		else
			throw new InvalidTokenException();

	}

	/**
	 * to get the list of all the patients only after verifying that the user trying
	 * to use this service is authenticated or not
	 */
	@GetMapping("/getallpatients")
	public List<TreatmentPlan> getAllPatients(@RequestHeader(name = "Authorization") String token)
			throws InvalidTokenException {

		boolean authResponse = authClient.verifyToken(token);
		log.info("Return  the list of  patients details");
		if (authResponse) {

			return iptService.getAllTreatment();
		} else {

			throw new InvalidTokenException();
		}
	}

	/**
	 * to get the specific patient details only after verifying that the user trying
	 * to use this service is authenticated or not
	 */
	@GetMapping("/getpatient/{ptId}")
	public PatientDetail getPatient(@PathVariable long ptId, @RequestHeader("Authorization") String token) {

		boolean authResponse = authClient.verifyToken(token);
		log.info("Returning the patient details by patient ID");
		if (authResponse) {

			return iptService.findPatientById(ptId);
		} else {

			throw new InvalidTokenException();
		}
	}

	/**
	 * to update the details of specific patient only after verifying that the user
	 * trying to use this service is authenticated or not
	 */
	@PutMapping("/updateplan/{patientId}")
	public void updatePlan(@PathVariable long patientId, @RequestHeader(name = "Authorization") String token)
			throws InvalidTokenException {

		boolean authResponse = authClient.verifyToken(token);
		log.info("To Edit the TreatmentPlan");
		if (authResponse) {

			iptService.updatePlan(patientId);
		} else {

			throw new InvalidTokenException();
		}
	}

	/**
	 * to get the list of all the On going only after verifying that the user trying
	 * to use this service is authenticated or not
	 */
	@GetMapping("/getallongoingtreatments")
	public List<TreatmentPlan> getAllOnGoingTreatments(@RequestHeader("Authorization") String token) {

		boolean response = authClient.verifyToken(token);
		log.info("Returning the details of ongoing treatments");
		if (response)
			return iptService.getAllGoingTreatments();
		else
			throw new InvalidTokenException();
	}

	@GetMapping("/getalltreatments")
	public List<TreatmentPlan> getalltreatments(@RequestHeader("Authorization") String token) {

		boolean response = authClient.verifyToken(token);
		log.info("Returning all the treatments undertaken");
		if (response)
			return iptService.getAllTreatment();
		else
			throw new InvalidTokenException();
	}

	/**
	 * to get the treatment plan of specific patient only after verifying that the
	 * user trying to use this service is authenticated or not
	 */
	@GetMapping("/getplan/{ptId}")
	public TreatmentPlan getAPlan(@PathVariable long ptId, @RequestHeader("Authorization") String token) {
		boolean response = authClient.verifyToken(token);
		log.info("Returning the TreatmentPlan By patientID ");
		if (response)
			return iptService.getTreatmentPlanById(ptId);
		else
			throw new InvalidTokenException();
	}

}
