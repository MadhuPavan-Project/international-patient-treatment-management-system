package com.cts.offerings.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PackageDetailTest {

	PackageDetail packageDetail = new PackageDetail();

	/**
	 * to test the constructor of package details.
	 */
	@Test
	public void testPackageDetailConstructor() {
		PackageDetail detail = new PackageDetail("Package 1", "Urology", 1000, 4);
		assertEquals(1000, detail.getCost());
	}

	/**
	 * to test the package details by setter and getter methods
	 * treatmentPackageName.
	 */
	@Test
	public void testTreatmentPackageName() {
		packageDetail.setTreatmentPackageName("Package 3");
		assertEquals("Package 3", packageDetail.getTreatmentPackageName());
	}

	/**
	 * to test the package details by setter and getter methods testDetails.
	 */
	@Test
	public void testTestDetails() {
		packageDetail.setTestDetails("OPT1,0PT3");
		assertEquals("OPT1,0PT3", packageDetail.getTestDetails());
	}

	/**
	 * to test the package details by setter and getter methods cost.
	 */
	@Test
	public void testCost() {
		packageDetail.setCost(5000);
		assertEquals(5000, packageDetail.getCost());
	}

	/**
	 * to test the package details by setter and getter methods treatmentDuration.
	 */
	@Test
	public void testTreatmentDuration() {
		packageDetail.setTreatmentDuration(4);
		assertEquals(4, packageDetail.getTreatmentDuration());
	}

	/**
	 * to test the toString method in package details .
	 */
	@Test
	public void testtoString() {
		String string = packageDetail.toString();
		assertEquals(string, packageDetail.toString());
	}

}