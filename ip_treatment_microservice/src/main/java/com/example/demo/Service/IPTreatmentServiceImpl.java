package com.example.demo.Service;

import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Client.FeignCallService;
import com.example.demo.Model.PatientDetail;
import com.example.demo.Model.TreatmentPlan;
import com.example.demo.Repository.PatientDetailRepository;
import com.example.demo.Repository.TreatmentPlanRepository;
import com.example.demo.exception.PatientNotFoundException;

@Service
public class IPTreatmentServiceImpl implements IPTreatmentService {

	@Autowired
	PatientDetailRepository patientDetailRepository;

	@Autowired
	TreatmentPlanRepository treatmentPlanRepository;

	@Autowired
	FeignCallService feign;

	/**
	 * to return the treatment plan
	 */
	@Override
	public TreatmentPlan getTreatmentPlan(PatientDetail patientDetail, String token) {

		Calendar currentDate = Calendar.getInstance();
		String commencementDate = reviewDateAndMonth(currentDate.get(Calendar.DATE)) + "/"
				+ reviewDateAndMonth(currentDate.get(Calendar.MONTH) + 1) + "/" + currentDate.get(Calendar.YEAR);
		patientDetail.setTreatmentCommencementDate(commencementDate);
		patientDetailRepository.save(patientDetail);
		String specialist = "None";
		String ailment = patientDetail.getAilment();
		String testDetail = "";
		double cost = feign.getCostForIPTreatment(patientDetail.getAilment(), patientDetail.getTreatmentPackageName(),
				token);

		String test1 = ailment.charAt(0) + "PT1";
		String test2 = ailment.charAt(0) + "PT2";
		String test3 = ailment.charAt(0) + "PT3";
		String test4 = ailment.charAt(0) + "PT4";

		if (patientDetail.getTreatmentPackageName().equalsIgnoreCase("package1")) {
			specialist = "Senior Specialist";
			testDetail = test1.toUpperCase() + "," + test2.toUpperCase();
			currentDate.add(Calendar.WEEK_OF_YEAR, 6);
		} else if (patientDetail.getTreatmentPackageName().equalsIgnoreCase("package2")) {
			specialist = "Junior Specialist";
			testDetail = test3.toUpperCase() + "," + test4.toUpperCase();
			currentDate.add(Calendar.WEEK_OF_YEAR, 4);
		}

		String endDate = reviewDateAndMonth(currentDate.get(Calendar.DATE)) + "/"
				+ reviewDateAndMonth(currentDate.get(Calendar.MONTH) + 1) + "/" + currentDate.get(Calendar.YEAR);

		TreatmentPlan plan = new TreatmentPlan(0, patientDetail, testDetail, patientDetail.getTreatmentPackageName(),
				specialist, cost, "In progress", commencementDate, endDate);

		treatmentPlanRepository.save(plan);

		return plan;
	}

	/**
	 * Converts the dateOrMonth to String and returns it.
	 */
	@Override
	public String reviewDateAndMonth(int dateOrMonth) {
		if (dateOrMonth < 10)
			return "0" + Integer.toString(dateOrMonth);
		else
			return Integer.toString(dateOrMonth);
	}

	/**
	 * to return all the registered patient
	 */
	@Override
	public List<PatientDetail> getAllPatients() {

		return patientDetailRepository.findAll();
	}

	/**
	 * to return all the treatment plans.
	 */
	@Override
	public List<TreatmentPlan> getAllTreatment() {

		return treatmentPlanRepository.findAll();
	}

	/**
	 * to return all the ongoing treatments.
	 */
	@Override
	public List<TreatmentPlan> getAllGoingTreatments() {

		return treatmentPlanRepository.findOnGoingPatients();
	}

	/**
	 * to return the patient details by id.
	 */
	public PatientDetail findPatientById(long ptId) throws PatientNotFoundException {

		PatientDetail patientDetail = patientDetailRepository.getPatientById(ptId);
		if (patientDetail == null) {
			throw new PatientNotFoundException(ptId);
		} else {
			return patientDetail;
		}
	}

	/**
	 * to update the treatment plan
	 */

	@Override
	public void updatePlan(long pId) throws PatientNotFoundException {

		TreatmentPlan treatmentPlan = treatmentPlanRepository.findByPtDetail(pId);
		if (treatmentPlan == null) {
			throw new PatientNotFoundException(pId);
		} else {
			treatmentPlan.setStatus("Completed");
			treatmentPlanRepository.save(treatmentPlan);
		}

	}

	/**
	 * to return treatment plan by id.
	 */
	@Override
	public TreatmentPlan getTreatmentPlanById(long ptId) throws PatientNotFoundException {

		TreatmentPlan treatmentPlan = treatmentPlanRepository.findByPtDetail(ptId);
		if (treatmentPlan == null) {
			throw new PatientNotFoundException(ptId);
		} else {
			return treatmentPlan;
		}
	}

}