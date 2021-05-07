package com.cts.insuranceclaim.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.insuranceclaim.model.InitiateClaim;
import com.cts.insuranceclaim.model.InsurerDetail;

@Service
public interface InsuranceClaimService {

	/**
	 * to return the list of all insurers
	 */
	public List<InsurerDetail> getAllInsurerDetails();

	/**
	 * to return the details of a insurer based on the insurer's package name
	 */

	public InsurerDetail getInsurerByPackageName(String packageName);

	/**
	 * to return the balance amount that the patient needs to pay after claiming his
	 * insurance
	 */

	public double getInitiateClaim(InitiateClaim initiateClaim, String token);

}
