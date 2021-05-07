package com.cts.offerings.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SpecialistDetailTest {

	SpecialistDetail specialistDetail = new SpecialistDetail();

	/**
	 * to test the constructor of specialist details.
	 */
	@Test
	public void testSpecialistDetailConstructor() {
		SpecialistDetail specialistDetail = new SpecialistDetail(1, "Dr. XYZ", "Urology", 5, "1234567890");
		assertEquals("Dr. XYZ", specialistDetail.getName());

	}

	/**
	 * to test the specialist details by setter setId.
	 */
	@Test
	public void testSetId() {
		specialistDetail.setId(101);
		assertEquals(101, specialistDetail.getId());
	}

	/**
	 * to test the specialist details by getter method getId.
	 */

	@Test
	public void testGetId() {
		specialistDetail.setId(101);
		assertEquals(101, specialistDetail.getId());
	}

	/**
	 * to test the specialist details by setter method setName.
	 */
	@Test
	public void testSetName() {
		specialistDetail.setName("Dr. XYZ");
		assertEquals("Dr. XYZ", specialistDetail.getName());
	}

	/**
	 * to test the specialist details by getter method getName.
	 */
	@Test
	public void testGetName() {
		specialistDetail.setName("Dr. XYZ");
		assertEquals("Dr. XYZ", specialistDetail.getName());
	}

	/**
	 * to test the specialist details by setter method setAreaOfExpertise.
	 */

	@Test
	public void testSetAreaOfExpertise() {
		specialistDetail.setAreaOfExpertise("Urology");
		assertEquals("Urology", specialistDetail.getAreaOfExpertise());
	}

	/**
	 * to test the specialist details by getter method getAreaOfExpertise.
	 */
	@Test
	public void testGetAreaOfExpertise() {
		specialistDetail.setAreaOfExpertise("Urology");
		assertEquals("Urology", specialistDetail.getAreaOfExpertise());

	}

	/**
	 * to test the specialist details by setter method setExperienceInYears.
	 */
	@Test
	public void testSetExperienceInYears() {
		specialistDetail.setExperienceInYears(10);
		assertEquals(10, specialistDetail.getExperienceInYears());
	}

	/**
	 * to test the specialist details by getter method getExperienceInYears.
	 */

	@Test
	public void testGetExperienceInYears() {
		specialistDetail.setExperienceInYears(10);
		assertEquals(10, specialistDetail.getExperienceInYears());
	}

	/**
	 * to test the specialist details by setter method setContactNumber.
	 */

	@Test
	public void testSetContactNumber() {
		specialistDetail.setContactNumber("1234567890");
		assertEquals("1234567890", specialistDetail.getContactNumber());
	}

	/**
	 * to test the specialist details by getter method getContactNumber.
	 */

	@Test
	public void testGetContactNumber() {
		specialistDetail.setContactNumber("1234567890");
		assertEquals("1234567890", specialistDetail.getContactNumber());
	}

}