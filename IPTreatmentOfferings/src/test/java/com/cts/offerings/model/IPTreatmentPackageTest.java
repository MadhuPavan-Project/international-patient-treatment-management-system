package com.cts.offerings.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class IPTreatmentPackageTest {

	IPTreatmentPackage ipTreatment = new IPTreatmentPackage();

	/**
	 * to test the IPTreatment package details by treatment id using patient
	 * details.
	 */
	@Test
	public void testIPTreatmentPackageDetailLongStringPackage() {
		PackageDetail packageDetail = new PackageDetail();
		IPTreatmentPackage treatment = new IPTreatmentPackage(101, "Urology", packageDetail);

		assertEquals(101, treatment.getId());
	}

	/**
	 * to test the IPTreatment package details by setter method setid.
	 */
	@Test
	public void testSetId() {
		ipTreatment.setId(10);
		assertEquals(10, ipTreatment.getId());
	}

	/**
	 * to test the IPTreatment package details by getter method getId.
	 */
	@Test
	public void testGetId() {
		ipTreatment.setId(10);
		assertEquals(10, ipTreatment.getId());

	}

	/**
	 * to test the IPTreatment package details by setter method setAilmentCategory.
	 */
	@Test
	public void testSetAilmentCategory() {
		ipTreatment.setAilmentCategory("Urology");
		assertEquals("Urology", ipTreatment.getAilmentCategory());
	}

	/**
	 * to test the IPTreatment package details by getter method getAilmentCategory.
	 */
	@Test
	public void testGetAilmentCategory() {
		ipTreatment.setAilmentCategory("Urology");
		assertEquals("Urology", ipTreatment.getAilmentCategory());
	}

	/**
	 * to test the IPTreatment package details by setter method setPackageDetail.
	 */
	@Test
	public void testSetPackageDetail() {
		PackageDetail detail = new PackageDetail();
		ipTreatment.setPackageDetail(detail);
		assertEquals(detail, ipTreatment.getPackageDetail());
	}

	/**
	 * to test the IPTreatment package details by getter method getPackageDetail.
	 */
	@Test
	public void testGetPackageDetail() {
		PackageDetail detail = new PackageDetail();
		ipTreatment.setPackageDetail(detail);
		assertEquals(detail, ipTreatment.getPackageDetail());
	}

}