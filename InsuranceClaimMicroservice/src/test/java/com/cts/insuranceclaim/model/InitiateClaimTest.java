package com.cts.insuranceclaim.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InitiateClaimTest {

	InitiateClaim initiateClaim = new InitiateClaim();

	/**
	 * to test the InitiateClaim setter method setId
	 */
	@Test
	void testSetId() {
		initiateClaim.setId(101);
		assertEquals(101, initiateClaim.getId());
	}

	/**
	 * to test the InitiateClaim getter method getId
	 */
	@Test
	void testGetId() {
		initiateClaim.setId(101);
		assertEquals(101, initiateClaim.getId());
	}

	/**
	 * to test the InitiateClaim setter method setPatientName
	 */
	@Test
	void testSetPatientName() {
		initiateClaim.setPatientName("Harry");
		assertEquals("Harry", initiateClaim.getPatientName());
	}

	/**
	 * to test the InitiateClaim getter method getPatientName
	 */
	@Test
	void testGetPatientName() {
		initiateClaim.setPatientName("Harry");
		assertEquals("Harry", initiateClaim.getPatientName());
	}

	/**
	 * to test the InitiateClaim setter method setAilment
	 */
	@Test
	void testSetAilment() {
		initiateClaim.setAilment("Urology");
		assertEquals("Urology", initiateClaim.getAilment());
	}

	/**
	 * to test the InitiateClaim getter method getAilment
	 */
	@Test
	void testGetAilment() {
		initiateClaim.setAilment("Urology");
		assertEquals("Urology", initiateClaim.getAilment());
	}

	/**
	 * to test the InitiateClaim setter method setTreatmentPackageName
	 */
	@Test
	void testSetTreatmentPackageName() {
		initiateClaim.setTreatmentPackageName("Package 5");
		assertEquals("Package 5", initiateClaim.getTreatmentPackageName());
	}

	/**
	 * to test the InitiateClaim getter method getTreatmentPackageName
	 */
	@Test
	void testGetTreatmentPackageName() {
		initiateClaim.setTreatmentPackageName("Package 5");
		assertEquals("Package 5", initiateClaim.getTreatmentPackageName());
	}

	/**
	 * to test the InitiateClaim setter method getPatientName
	 */
	@Test
	void testSetInsurerName() {
		initiateClaim.setInsurerName("XYZ");
		assertEquals("XYZ", initiateClaim.getInsurerName());
	}

	/**
	 * to test the InitiateClaim getter method getInsurerName
	 */
	@Test
	void testGetInsurerName() {
		initiateClaim.setInsurerName("XYZ");
		assertEquals("XYZ", initiateClaim.getInsurerName());
	}
}
