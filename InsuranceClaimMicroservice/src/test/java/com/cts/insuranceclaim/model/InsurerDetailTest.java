package com.cts.insuranceclaim.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InsurerDetailTest {

	InsurerDetail insurerDetail = new InsurerDetail();

	/**
	 * to Test the InsurerDetail getter method getId()
	 */
	@Test
	void testSetId() {
		insurerDetail.setId(12);
		assertEquals(12, insurerDetail.getId());
	}

	/**
	 * to Test the InsurerDetail setter method setId()
	 */
	@Test
	void testGetId() {
		insurerDetail.setId(12);
		assertEquals(12, insurerDetail.getId());
	}

	/**
	 * to Test the InsurerDetail getter method getInsurerName()
	 */
	@Test
	void testSetInsurerName() {
		insurerDetail.setInsurerName("XYZ");
		assertEquals("XYZ", insurerDetail.getInsurerName());
	}

	/**
	 * to Test the InsurerDetail setter method setInsurerName()
	 */
	@Test
	void testGetInsurerName() {
		insurerDetail.setInsurerName("XYZ");
		assertEquals("XYZ", insurerDetail.getInsurerName());
	}

	/**
	 * to Test the InsurerDetail getter method getInsurerPackageName()
	 */
	@Test
	void testSetInsurerPackageName() {
		insurerDetail.setInsurerPackageName("Package 1");
		assertEquals("Package 1", insurerDetail.getInsurerPackageName());
	}

	/**
	 * to Test the InsurerDetail setter method setInsurerPackageName()
	 */
	@Test
	void testGetInsurerPackageName() {
		insurerDetail.setInsurerPackageName("Package 1");
		assertEquals("Package 1", insurerDetail.getInsurerPackageName());
	}

	/**
	 * to Test the InsurerDetail getter method getInsuranceAmountLimit()
	 */
	@Test
	void testSetInsuranceAmountLimit() {
		insurerDetail.setInsuranceAmountLimit(123456);
		assertEquals(123456, insurerDetail.getInsuranceAmountLimit());
	}

	/**
	 * to Test the InsurerDetail setter method setInsuranceAmountLimit()
	 */
	@Test
	void testGetInsuranceAmountLimit() {
		insurerDetail.setInsuranceAmountLimit(123456);
		assertEquals(123456, insurerDetail.getInsuranceAmountLimit());
	}

	/**
	 * to Test the InsurerDetail getter method getDisbursementDuration()
	 */
	@Test
	void testSetDisbursementDuration() {
		insurerDetail.setDisbursementDuration(10);
		assertEquals(10, insurerDetail.getDisbursementDuration());
	}

	/**
	 * to Test the InsurerDetail setter method setDisbursementDuration()
	 */
	@Test
	void testGetDisbursementDuration() {
		insurerDetail.setDisbursementDuration(10);
		assertEquals(10, insurerDetail.getDisbursementDuration());
	}

	/**
	 * to Test the InsurerDetail Constructor
	 */
	@Test
	void testInsurerDetailConstructor() {
		InsurerDetail insurer = new InsurerDetail(12, "XYZ", "Package 1", 123456, 10);
		assertEquals("XYZ", insurer.getInsurerName());
	}

}