package com.cts.offerings.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.offerings.model.IPTreatmentPackage;
import com.cts.offerings.model.SpecialistDetail;

@Service
public interface IPTreatmentPackageService {
	/**
	 * return all the IPTreatmentPackage.
	 */

	public List<IPTreatmentPackage> getIPTreatmentPackages();

	/**
	 * return all the SpecialistDetail.
	 */
	public List<SpecialistDetail> getSpecialist();

	/**
	 * return the cost of the treatment by ailment category and package name.
	 */
	public double getCostforIpTreatmentPackages(String ailment, String packageName);

	/**
	 * return all the IPTreatmentPackage by ailment category and package name.
	 */
	public IPTreatmentPackage getTreatmentPackages(String ailment, String packageName);

}
