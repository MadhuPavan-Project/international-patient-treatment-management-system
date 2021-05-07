package com.example.demo.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.Model.PatientDetail;
import com.example.demo.Model.TreatmentPlan;

@Service
public interface IPTreatmentService {

	/**
	 * to return the treatment plan
	 */
	TreatmentPlan getTreatmentPlan(PatientDetail patientDetail, String token);

	/**
	 * Converts the dateOrMonth to String and returns it.
	 */
	public String reviewDateAndMonth(int dateOrMonth);

	/**
	 * return all the patients
	 */
	List<PatientDetail> getAllPatients();

	/**
	 * return all the treatments
	 */
	List<TreatmentPlan> getAllTreatment();

	/*
	 * return all the on going treatments
	 */
	public List<TreatmentPlan> getAllGoingTreatments();

	/**
	 * return the patient details by patient id
	 */
	public PatientDetail findPatientById(long ptId);

	/**
	 * to update the treatment plan by patient id.
	 */
	public void updatePlan(long pId);

	/**
	 * return the treatment plans by id.
	 */
	public TreatmentPlan getTreatmentPlanById(long ptId);

}