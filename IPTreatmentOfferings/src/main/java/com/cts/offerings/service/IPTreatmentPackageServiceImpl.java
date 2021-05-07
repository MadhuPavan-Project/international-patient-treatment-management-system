package com.cts.offerings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.offerings.exception.PackageDetailNotFoundException;
import com.cts.offerings.model.IPTreatmentPackage;
import com.cts.offerings.model.SpecialistDetail;
import com.cts.offerings.repository.IPTreatmentPackageRepository;
import com.cts.offerings.repository.SpecialistDetailRepository;

@Service
public class IPTreatmentPackageServiceImpl implements IPTreatmentPackageService {

	@Autowired
	IPTreatmentPackageRepository ipTreatmentPackageRepository;

	@Autowired
	SpecialistDetailRepository specialistDetailRepository;

	/**
	 * return all the IPTreatmentPackage.
	 */
	public List<IPTreatmentPackage> getIPTreatmentPackages() {
		return ipTreatmentPackageRepository.findAll();
	}

	/**
	 * return all the SpecialistDetail.
	 */
	public List<SpecialistDetail> getSpecialist() {
		return specialistDetailRepository.findAll();
	}

	/**
	 * return the cost of the treatment by ailment category and package name.
	 */
	@Override
	public double getCostforIpTreatmentPackages(String ailment, String packageName) {

		IPTreatmentPackage iPTreatmentPackage = ipTreatmentPackageRepository.getByPackageNameAndAilment(packageName,
				ailment);
		if (iPTreatmentPackage == null)
			throw new PackageDetailNotFoundException(packageName);
		else
			return iPTreatmentPackage.getPackageDetail().getCost();
	}

	/**
	 * return all the IPTreatmentPackage by ailment category and package name.
	 */
	@Override
	public IPTreatmentPackage getTreatmentPackages(String ailment, String packageName) {
		IPTreatmentPackage iPTreatmentPackage = ipTreatmentPackageRepository.getByPackageNameAndAilment(packageName,
				ailment);
		if (iPTreatmentPackage == null)
			throw new PackageDetailNotFoundException();
		else
			return iPTreatmentPackage;

	}

}
