package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.demo.Model.TreatmentPlan;

public class TreatmentPlanTest {

	TreatmentPlan treatmentPlan = new TreatmentPlan();

	/**
	 * to test the treatmentPlan setter method setId.
	 */
	@Test
	public void testSetId() {
		treatmentPlan.setId(10);
		assertEquals(10, treatmentPlan.getId());
	}

	/**
	 * to test the treatmentPlan getter method getId.
	 */
	@Test
	public void testGetId() {
		treatmentPlan.setId(10);
		assertEquals(10, treatmentPlan.getId());
	}

	/**
	 * to test the treatmentPlan setter method setTestDetails.
	 */
	@Test
	public void testSetTestDetails() {
		treatmentPlan.setTestDetails("Urology");
		assertEquals("Urology", treatmentPlan.getTestDetails());
	}

	/**
	 * to test the treatmentPlan getter method getTestDetails.
	 */
	@Test
	public void testGetTestDetails() {
		treatmentPlan.setTestDetails("Urology");
		assertEquals("Urology", treatmentPlan.getTestDetails());
	}

	/**
	 * to test the treatmentPlan setter method setPackageName.
	 */
	@Test
	public void testSetPackageName() {
		treatmentPlan.setPackageName("Package 1");
		assertEquals("Package 1", treatmentPlan.getPackageName());
	}

	/**
	 * to test the treatmentPlan getter method getPackageName.
	 */
	@Test
	public void testGetPackageName() {
		treatmentPlan.setPackageName("Package 1");
		assertEquals("Package 1", treatmentPlan.getPackageName());
	}

	/**
	 * to test the treatmentPlan setter method setSpecialist.
	 */
	@Test
	public void testSetSpecialist() {
		treatmentPlan.setSpecialist("Orthopeadics");
		assertEquals("Orthopeadics", treatmentPlan.getSpecialist());
	}

	/**
	 * to test the treatmentPlan getter method getSpecialist.
	 */
	@Test
	public void testGetSpecialist() {
		treatmentPlan.setSpecialist("Orthopeadics");
		assertEquals("Orthopeadics", treatmentPlan.getSpecialist());
	}

	/**
	 * to test the treatmentPlan setter method setCost.
	 */
	@Test
	public void testSetCost() {
		treatmentPlan.setCost(5000);
		assertEquals(5000, treatmentPlan.getCost());
	}

	/**
	 * to test the treatmentPlan getter method getCost.
	 */
	@Test
	public void testGetCost() {
		treatmentPlan.setCost(5000);
		assertEquals(5000, treatmentPlan.getCost());
	}

	/**
	 * to test the treatmentPlan setter method setStatus.
	 */
	@Test
	public void testSetStatus() {
		treatmentPlan.setStatus("In progress");
		assertEquals("In progress", treatmentPlan.getStatus());
	}

	/**
	 * to test the treatmentPlan getter method getStatus.
	 */
	@Test
	public void testGetStatus() {
		treatmentPlan.setStatus("In progress");
		assertEquals("In progress", treatmentPlan.getStatus());
	}

	/**
	 * to test the treatmentPlan setter method setTreatmentCommencementDate.
	 */
	@Test
	public void testSetTreatmentCommencementDate() {
		treatmentPlan.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020", treatmentPlan.getTreatmentCommencementDate());
	}

	/**
	 * to test the treatmentPlan getter method getTreatmentCommencementDate.
	 */
	@Test
	public void testGetTreatmentCommencementDate() {
		treatmentPlan.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020", treatmentPlan.getTreatmentCommencementDate());
	}

	/**
	 * to test the treatmentPlan setter method setTreatmentEndDate.
	 */
	@Test
	public void testSetTreatmentEndDate() {
		treatmentPlan.setTreatmentEndDate("10/12/2020");
		assertEquals("10/12/2020", treatmentPlan.getTreatmentEndDate());
	}

	/**
	 * to test the treatmentPlan getter method getTreatmentEndDate.
	 */
	@Test
	public void testGetTreatmentEndDate() {
		treatmentPlan.setTreatmentEndDate("10/12/2020");
		assertEquals("10/12/2020", treatmentPlan.getTreatmentEndDate());
	}

}