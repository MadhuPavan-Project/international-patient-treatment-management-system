package com.cts.insuranceclaim.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PatientDetailTest {

	PatientDetail patientDetail = new PatientDetail();

	/**
	 * to test the PatientDetail constructor
	 */
	@Test
	void testPatientDetailLongStringIntStringStringString() {
		PatientDetail patientData = new PatientDetail(101, "Harry", 24, "Urology", "Package 1", "10/11/2020");
		assertEquals(101, patientData.getId());

	}

	/**
	 * to test the PatientDetail setter method setId
	 */
	@Test
	void testSetId() {
		patientDetail.setId(101);
		assertEquals(101, patientDetail.getId());
	}

	/**
	 * to test the PatientDetail getter method getId
	 */
	@Test
	void testGetId() {
		patientDetail.setId(101);
		assertEquals(101, patientDetail.getId());
	}

	/**
	 * to test the PatientDetail setter method setName
	 */
	@Test
	void testSetName() {
		patientDetail.setName("Harry");
		;
		assertEquals("Harry", patientDetail.getName());
	}

	/**
	 * to test the PatientDetail getter method getName
	 */
	@Test
	void testGetName() {

		patientDetail.setName("Harry");
		;
		assertEquals("Harry", patientDetail.getName());

	}

	/**
	 * to test the PatientDetail setter method setAge
	 */
	@Test
	void testSetAge() {
		patientDetail.setAge(24);
		assertEquals(24, patientDetail.getAge());
	}

	/**
	 * to test the PatientDetail getter method getAge
	 */
	@Test
	void testGetAge() {
		patientDetail.setAge(24);

		assertEquals(24, patientDetail.getAge());
	}

	/**
	 * to test the PatientDetail setter method setAilment
	 */
	@Test
	void testSetAilment() {
		patientDetail.setAilment("Urology");
		;
		assertEquals("Urology", patientDetail.getAilment());
	}

	/**
	 * to test the PatientDetail getter method getAilment
	 */
	@Test
	void testGetAilment() {
		patientDetail.setAilment("Urology");
		;
		assertEquals("Urology", patientDetail.getAilment());
	}

	/**
	 * to test the PatientDetail setter method setTreatmentPackageName
	 */
	@Test
	void testSetTreatmentPackageName() {
		patientDetail.setTreatmentPackageName("Package 1");
		assertEquals("Package 1", patientDetail.getTreatmentPackageName());
	}

	/**
	 * to test the PatientDetail getter method getTreatmentPackageName
	 */
	@Test
	void testGetTreatmentPackageName() {
		patientDetail.setTreatmentPackageName("Package 1");
		assertEquals("Package 1", patientDetail.getTreatmentPackageName());
	}

	/**
	 * to test the PatientDetail setter method setTreatmentCommencementDate
	 */
	@Test
	void testSetTreatmentCommencementDate() {
		patientDetail.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020", patientDetail.getTreatmentCommencementDate());
	}

	/**
	 * to test the PatientDetail getter method getTreatmentCommencementDate
	 */
	@Test
	void testGetTreatmentCommencementDate() {
		patientDetail.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020", patientDetail.getTreatmentCommencementDate());
	}

}
