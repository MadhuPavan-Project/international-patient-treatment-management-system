package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.clients.ICClient;
import com.cognizant.clients.IPTFClient;
import com.cognizant.clients.IPTOFClient;
import com.cognizant.model.IPTreatmentPackage;
import com.cognizant.model.InitiateClaim;
import com.cognizant.model.InsurerDetail;
import com.cognizant.model.PatientDetail;
import com.cognizant.model.SpecialistDetail;
import com.cognizant.model.TreatmentPlan;

@Service
public class PortalService {

	@Autowired
	private IPTFClient iPTFClient;

	@Autowired
	private IPTOFClient iPTFOClient;

	@Autowired
	private ICClient iCClient;

	/**
	 * return the list of all specialists.
	 */
	public List<SpecialistDetail> getSpecialistDetail(String token) {

		return iPTFOClient.getSpecialists(token);
	}

	/**
	 * return the list of all Insurer details.
	 */
	public List<InsurerDetail> getInsurerDetail(String token) {
		return iCClient.getAllInsurerDetails(token);
	}

	/**
	 * return the Treatment Plan of a Patient
	 */
	public TreatmentPlan registerPatient(PatientDetail patient, String token) {
		return iPTFClient.getTreatmentTimetable(patient, token);
	}

	/**
	 * return the List of Treatment Packages Available in the Hospital.
	 */
	public List<IPTreatmentPackage> getPackageDetail(String token) {

		return (List<IPTreatmentPackage>) iPTFOClient.getAllIPTreatmentPackages(token);
	}

	/**
	 * return the List of ALL Treatments in the Hospital.
	 */
	public List<TreatmentPlan> getTreatmentPlanList(String token) {
		return iPTFClient.getAllPatients(token);
	}

	/**
	 * return the List of On Going Treatments in the Hospital.
	 */
	public List<TreatmentPlan> getOnGoingTreatmentPlanList(String token) {
		return iPTFClient.getAllOnGoingTreatments(token);
	}

	/**
	 * return the Particular Insurance Provider selected for a patient.
	 */
	public InsurerDetail getInsurerDetail(String packageName, String token) {

		return iCClient.getInsurerByPackageName(packageName, token);
	}

	/**
	 * return the Particular Patient based on patient ID..
	 */
	public PatientDetail getPatientDetail(long ptId, String token) {

		return iPTFClient.getPatient(ptId, token);
	}

	/**
	 * return the Treatment Plan of a Particular Patient.
	 */
	public TreatmentPlan getTreatmentDetail(long ptId, String token) {
		return iPTFClient.getAPlan(ptId, token);
	}

	/**
	 * return the Remaining Amount to be paid after claim Settlement.
	 */
	public double initiateClaim(InitiateClaim initiateClaim, String token) {

		return iCClient.getInitiateCliam(initiateClaim, token);
	}

	/**
	 * return the List of Available Insurers in the Hospital.
	 */
	public List<InsurerDetail> claimInsurance(String token) {
		return iCClient.getAllInsurerDetails(token);
	}

	/**
	 * Update Patient Status from On Progress to Complete.
	 */
	public void updatePlan(long ptId, String token) {
		iPTFClient.updatePlan(ptId, token);
	}

}
