package com.cts.insuranceclaim.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TreatmentPlanTest {

	TreatmentPlan treatmentPlan = new TreatmentPlan();

	/**
	 * to test the TreatmentPlan setter method setId
	 */
	@Test
	void testSetId() {
		treatmentPlan.setId(10);
		assertEquals(10, treatmentPlan.getId());
	}

	/**
	 * to test the TreatmentPlan getter method getId
	 */
	@Test
	void testGetId() {
		treatmentPlan.setId(10);
		assertEquals(10, treatmentPlan.getId());
	}

	/**
	 * to test the TreatmentPlan setter method setTestDetails
	 */
	@Test
	void testSetTestDetails() {
		treatmentPlan.setTestDetails("Urology");
		assertEquals("Urology", treatmentPlan.getTestDetails());
	}

	/**
	 * to test the TreatmentPlan getter method getTestDetails
	 */
	@Test
	void testGetTestDetails() {
		treatmentPlan.setTestDetails("Urology");
		assertEquals("Urology", treatmentPlan.getTestDetails());
	}

	/**
	 * to test the TreatmentPlan setter method setPackageName
	 */
	@Test
	void testSetPackageName() {
		treatmentPlan.setPackageName("Package 1");
		assertEquals("Package 1", treatmentPlan.getPackageName());
	}

	/**
	 * to test the TreatmentPlan getter method getPackageName
	 */
	@Test
	void testGetPackageName() {
		treatmentPlan.setPackageName("Package 1");
		assertEquals("Package 1", treatmentPlan.getPackageName());
	}

	/**
	 * to test the TreatmentPlan setter method setSpecialist
	 */
	@Test
	void testSetSpecialist() {
		treatmentPlan.setSpecialist("Orthopeadics");
		assertEquals("Orthopeadics", treatmentPlan.getSpecialist());
	}

	/**
	 * to test the TreatmentPlan getter method getSpecialist
	 */
	@Test
	void testGetSpecialist() {
		treatmentPlan.setSpecialist("Orthopeadics");
		assertEquals("Orthopeadics", treatmentPlan.getSpecialist());
	}

	/**
	 * to test the TreatmentPlan setter method setStatus
	 */
	@Test
	void testSetStatus() {
		treatmentPlan.setStatus("In progress");
		assertEquals("In progress", treatmentPlan.getStatus());
	}

	/**
	 * to test the TreatmentPlan getter method getStatus
	 */
	@Test
	void testGetStatus() {
		treatmentPlan.setStatus("In progress");
		assertEquals("In progress", treatmentPlan.getStatus());
	}

	/**
	 * to test the TreatmentPlan setter method setTreatmentCommencementDate
	 */
	@Test
	void testSetTreatmentCommencementDate() {
		treatmentPlan.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020", treatmentPlan.getTreatmentCommencementDate());
	}

	/**
	 * to test the TreatmentPlan getter method getTreatmentCommencementDate
	 */
	@Test
	void testGetTreatmentCommencementDate() {
		treatmentPlan.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020", treatmentPlan.getTreatmentCommencementDate());
	}

	/**
	 * to test the TreatmentPlan setter method setTreatmentEndDate
	 */
	@Test
	void testSetTreatmentEndDate() {
		treatmentPlan.setTreatmentEndDate("10/12/2020");
		assertEquals("10/12/2020", treatmentPlan.getTreatmentEndDate());
	}

	/**
	 * to test the TreatmentPlan getter method getTreatmentEndDate
	 */
	@Test
	void testGetTreatmentEndDate() {
		treatmentPlan.setTreatmentEndDate("10/12/2020");
		assertEquals("10/12/2020", treatmentPlan.getTreatmentEndDate());
	}

}
