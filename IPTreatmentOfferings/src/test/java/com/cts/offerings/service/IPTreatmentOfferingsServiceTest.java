package com.cts.offerings.service;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cts.offerings.client.AuthClient;
import com.cts.offerings.exception.PackageDetailNotFoundException;
import com.cts.offerings.model.IPTreatmentPackage;
import com.cts.offerings.model.PackageDetail;
import com.cts.offerings.model.SpecialistDetail;
import com.cts.offerings.repository.IPTreatmentPackageRepository;
import com.cts.offerings.repository.SpecialistDetailRepository;

@ExtendWith(MockitoExtension.class)
public class IPTreatmentOfferingsServiceTest {

	/**
	 * @InjectMocks annotation can be used to inject mock fields into a test object
	 *              automatically
	 */
	@Mock
	IPTreatmentPackageRepository ipTreatmentOfferingsRepository;

	@Mock
	SpecialistDetailRepository ipTreatmentOfferingsSpecialistDetaiLRepository;

	@Mock
	AuthClient authClient;

	@InjectMocks
	IPTreatmentPackageServiceImpl ipTreatmentOfferingsServiceImpl;

	/**
	 * to test that all IP treatment packages are fetched properly
	 */
	@Test
	public void testGetIPTreatmentPackages() {
		List<IPTreatmentPackage> ipTreatmentPackages = new ArrayList<IPTreatmentPackage>();
		PackageDetail packageDetail = new PackageDetail("Package 1", "UTP 1,UTP 2", 12000, 4);
		IPTreatmentPackage ipTreatmentPackage = new IPTreatmentPackage(1, "Urology", packageDetail);
		ipTreatmentPackages.add(ipTreatmentPackage);
		when(ipTreatmentOfferingsRepository.findAll()).thenReturn(ipTreatmentPackages);
		assertEquals(ipTreatmentPackages, ipTreatmentOfferingsServiceImpl.getIPTreatmentPackages());
	}

	/**
	 * to test that all IP treatment packages are fetched properly by package name
	 * and ailment category.
	 */
	@Test
	public void testGetIPTreatmentPackageByAilmentCategoryAndName() {
		PackageDetail packageDetail1 = new PackageDetail("Package 1", "UTP1, UTP2", 25000, 4);
		PackageDetail packageDetail2 = new PackageDetail("Package 2", "OTP1, OTP2", 18000, 6);
		IPTreatmentPackage iPTreatmentPackage1 = new IPTreatmentPackage(45, "Urology", packageDetail1);
		IPTreatmentPackage iPTreatmentPackage2 = new IPTreatmentPackage(48, "Orthopaedics", packageDetail2);
		when(ipTreatmentOfferingsRepository.getByPackageNameAndAilment("Package 1", "Urology"))
				.thenReturn(iPTreatmentPackage1);
		when(ipTreatmentOfferingsRepository.getByPackageNameAndAilment("Package 2", "Orthopaedics"))
				.thenReturn(iPTreatmentPackage2);
		when(ipTreatmentOfferingsRepository.getByPackageNameAndAilment("Package 22", "Urology")).thenReturn(null);
		assertEquals(iPTreatmentPackage1, ipTreatmentOfferingsServiceImpl.getTreatmentPackages("Urology", "Package 1"));
		assertEquals(iPTreatmentPackage2,
				ipTreatmentOfferingsServiceImpl.getTreatmentPackages("Orthopaedics", "Package 2"));

		assertThrows(PackageDetailNotFoundException.class,
				() -> ipTreatmentOfferingsServiceImpl.getTreatmentPackages("Urology", "Package 22"));
	}

	/**
	 * to test the cost of IP treatment package fetched properly.
	 */
	@Test
	public void testGetCostIPTreatmentPackageByAilmentCategoryAndName() {
		PackageDetail packageDetail1 = new PackageDetail("Package 1", "UTP1, UTP2", 25000, 4);
		IPTreatmentPackage iPTreatmentPackage1 = new IPTreatmentPackage(45, "Urology", packageDetail1);
		when(ipTreatmentOfferingsRepository.getByPackageNameAndAilment("Package 1", "Urology"))
				.thenReturn(iPTreatmentPackage1);
		assertEquals(25000, ipTreatmentOfferingsServiceImpl.getCostforIpTreatmentPackages("Urology", "Package 1"));

	}
	@Test
	public void testGetCostForInvalidPackage() {
		when(ipTreatmentOfferingsRepository.getByPackageNameAndAilment("Package 1", "Urology"))
		.thenReturn(null);
		assertThrows(PackageDetailNotFoundException.class, () ->  ipTreatmentOfferingsServiceImpl.getCostforIpTreatmentPackages("Urology", "Package 1"));

	}

	/**
	 * to test that all specialists are fetched properly
	 */
	@Test
	public void testGetSpecialists() {
		List<SpecialistDetail> specialistDetails = new ArrayList<SpecialistDetail>();
		SpecialistDetail specialistDetail = new SpecialistDetail(1, "Dr. XYZ", "Orthopaedics", 12,
				"9876543210");
		specialistDetails.add(specialistDetail);
		when(ipTreatmentOfferingsSpecialistDetaiLRepository.findAll()).thenReturn(specialistDetails);
		assertEquals(specialistDetails, ipTreatmentOfferingsServiceImpl.getSpecialist());

	}

}