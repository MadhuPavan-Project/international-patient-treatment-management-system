package com.cts.insuranceclaim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.insuranceclaim.Client.OfferingClient;
import com.cts.insuranceclaim.exception.InsurerDetailNotFoundException;
import com.cts.insuranceclaim.model.InitiateClaim;
import com.cts.insuranceclaim.model.InsurerDetail;

import com.cts.insuranceclaim.repository.InitiateClaimRepository;
import com.cts.insuranceclaim.repository.InsurerDetailRepository;

@Service
public class InsuranceClaimServiceImpl implements InsuranceClaimService {

	@Autowired
	InitiateClaimRepository initiateClaimRepository;

	@Autowired
	InsurerDetailRepository insurerDetailRepository;

	@Autowired
	OfferingClient offeringClient;

	/*
	 * to return list of all the available insurer details.
	 */

	@Override
	public List<InsurerDetail> getAllInsurerDetails() throws InsurerDetailNotFoundException {

		try {
			return insurerDetailRepository.findAll();
		} catch (Exception e) {
			throw new InsurerDetailNotFoundException();
		}
	}

	/*
	 * to return InsurerDetail based on the packageName given by the user.
	 */
	@Override
	public InsurerDetail getInsurerByPackageName(String packageName) throws InsurerDetailNotFoundException {

		InsurerDetail insurerDetail = insurerDetailRepository.findByInsurerPackageName(packageName);
		if (insurerDetail == null) {
			throw new InsurerDetailNotFoundException(
					"Insurer details not found with insurer package name :" + packageName);
		} else {
			return insurerDetail;
		}
	}

	/*
	 * to return balance amount after the admin initiated the claim for the patient.
	 */

	@Override
	public double getInitiateClaim(InitiateClaim initiateClaim, String token) throws InsurerDetailNotFoundException {

		double treatmentCost = offeringClient.getCostForIPTreatment(initiateClaim.getAilment(),
				initiateClaim.getTreatmentPackageName(), token);

		InsurerDetail insurerDetail = insurerDetailRepository.findByInsurerName(initiateClaim.getInsurerName());
		double insuranceLimit = insurerDetail.getInsuranceAmountLimit();
		double balanceAmount = treatmentCost - insuranceLimit;
		return balanceAmount;

	}

}
