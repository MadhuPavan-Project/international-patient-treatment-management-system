package com.cts.insuranceclaim.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cts.insuranceclaim.Client.AuthClient;

import com.cts.insuranceclaim.Client.OfferingClient;
import com.cts.insuranceclaim.exception.InsurerDetailNotFoundException;
import com.cts.insuranceclaim.model.InitiateClaim;
import com.cts.insuranceclaim.model.InsurerDetail;
import com.cts.insuranceclaim.model.PatientDetail;
import com.cts.insuranceclaim.model.TreatmentPlan;
import com.cts.insuranceclaim.repository.InitiateClaimRepository;
import com.cts.insuranceclaim.repository.InsurerDetailRepository;

@ExtendWith(MockitoExtension.class)
class InsuranceClaimServiceImplTest {

	@Mock
	InsurerDetailRepository insurerDetailRepository;

	@Mock
	InitiateClaimRepository initiateClaimRepository;

	@InjectMocks
	InsuranceClaimServiceImpl insuranceClaimServiceImpl;

	@Mock
	AuthClient authClient;

	@Mock
	OfferingClient offeringClient;

	/**
	 * to test all insurer details fetched properly
	 */
	@Test
	void testGetAllInsurerDetail() {
		List<InsurerDetail> insurerDetailList = new ArrayList<InsurerDetail>();
		insurerDetailList.add(new InsurerDetail(0l, "Life Insurance Corporation", "Individual Health Plan", 4000, 10));
		when(insurerDetailRepository.findAll()).thenReturn(insurerDetailList);
		assertEquals("Individual Health Plan",
				insuranceClaimServiceImpl.getAllInsurerDetails().get(0).getInsurerPackageName());
	}

	/**
	 * to test failure in getting the list of all insurer details
	 */
	@Test
	void testGetAllInsurerDetailFailed() {
		when(insurerDetailRepository.findAll()).thenThrow(new RuntimeException());
		assertThrows(InsurerDetailNotFoundException.class, () -> insuranceClaimServiceImpl.getAllInsurerDetails());
	}

	/**
	 * to test that the insurer details are fetched properly
	 */
	@Test
	void testGetInsurerDetail() {
		InsurerDetail ins = new InsurerDetail(0, "Life Insurance Corporation", "Individual Health Plan", 4000, 10);
		when(insurerDetailRepository.findByInsurerPackageName("Individual Health Plan")).thenReturn(ins);
		assertEquals("Individual Health Plan",
				insuranceClaimServiceImpl.getInsurerByPackageName("Individual Health Plan").getInsurerPackageName());
	}

	/**
	 * 
	 * to test the failure in fetching the insurer details
	 */
	@Test
	void testGetInsurerDetailFailed() {
		when(insurerDetailRepository.findByInsurerPackageName("Individual Health Plan")).thenReturn(null);
		assertThrows(InsurerDetailNotFoundException.class,
				() -> insuranceClaimServiceImpl.getInsurerByPackageName("Individual Health Plan"));
	}

	/**
	 * to test the functioning of initiating claim
	 */
	@Test
	void testInitiateClaim() {
		PatientDetail patientDetail = new PatientDetail(1, "John", 25, "Arthritis", "Package2", "10/03/2021");
		TreatmentPlan treatmentPlan = new TreatmentPlan(1, patientDetail, "Test1", "Package2", "Junior Specialist",
				18000, "In Progress", "10/03/2021", "10/04/2021");

		when(offeringClient.getCostForIPTreatment(patientDetail.getAilment(), patientDetail.getTreatmentPackageName(),
				"token")).thenReturn(treatmentPlan.getCost());
		InsurerDetail insurerDetail = new InsurerDetail(1, "Life Insurance Corporation", "Individual Health Plan", 4000,
				10);
		InitiateClaim initiateClaim = new InitiateClaim(1, "John", "Arthritis", "Package2",
				"Life Insurance Corporation");
		when(insurerDetailRepository.findByInsurerName(insurerDetail.getInsurerName())).thenReturn(insurerDetail);
		assertEquals(14000, insuranceClaimServiceImpl.getInitiateClaim(initiateClaim, "token"));
	}

}