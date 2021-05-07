package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.Client.AuthClient;
import com.example.demo.Client.FeignCallService;
import com.example.demo.Model.PatientDetail;
import com.example.demo.Model.TreatmentPlan;
import com.example.demo.Repository.PatientDetailRepository;
import com.example.demo.Repository.TreatmentPlanRepository;
import com.example.demo.Service.IPTreatmentServiceImpl;
import com.example.demo.exception.PatientNotFoundException;

@ExtendWith(MockitoExtension.class)
class IPTreatmentServiceImplTest {

	/**
	 * @InjectMocks annotation can be used to inject mock fields into a test object
	 *              automatically
	 */
	@Mock
	PatientDetailRepository patientDetailRepository;

	@Mock
	AuthClient authClient;

	@Mock
	FeignCallService feign;

	@Mock
	TreatmentPlanRepository treatmentPlanRepository;

	@InjectMocks
	IPTreatmentServiceImpl iPTreatmentServiceImpl;

	/**
	 * to test treatment plan fetched properly by package1
	 */
	@Test
	public void testGetTreatmentPlanPackage1() {
		PatientDetail patientDetail = new PatientDetail(1, "John", 26, "Arthritis", "Package1", "10/03/2021");
		TreatmentPlan treatmentPlan = iPTreatmentServiceImpl.getTreatmentPlan(patientDetail, "Bearer token");
		assertEquals("Senior Specialist", treatmentPlan.getSpecialist());
		verify(treatmentPlanRepository, times(1)).save(treatmentPlan);
		verify(patientDetailRepository, times(1)).save(patientDetail);
	}

	/**
	 * to test treatment plan fetched properly by package2
	 */
	@Test
	public void testGetTreatmentPlanPackage2() {
		PatientDetail patientDetail = new PatientDetail(1, "John", 26, "Arthritis", "Package2", "10/03/2021");
		TreatmentPlan treatmentPlan = iPTreatmentServiceImpl.getTreatmentPlan(patientDetail, "Bearer token");
		assertEquals("Junior Specialist", treatmentPlan.getSpecialist());
		verify(treatmentPlanRepository, times(1)).save(treatmentPlan);
		verify(patientDetailRepository, times(1)).save(patientDetail);
	}

	/**
	 * to test the reviewDateAndMonth
	 */

	@Test
	public void testReviewDateAndMonth() {
		assertEquals("10", iPTreatmentServiceImpl.reviewDateAndMonth(10));
		assertEquals("01", iPTreatmentServiceImpl.reviewDateAndMonth(1));
		assertEquals("05", iPTreatmentServiceImpl.reviewDateAndMonth(5));
	}

	/**
	 * to test treatment plan fetched all the plans properly
	 */
	@Test
	public void testGetAllPlans() {
		List<TreatmentPlan> treatmentPlans = new ArrayList<TreatmentPlan>();
		PatientDetail patientDetail = new PatientDetail(1, "John", 26, "Arthritis", "Package2", "10/03/2021");
		TreatmentPlan treatmentPlan = new TreatmentPlan(1, patientDetail, "Test1", "Package2", "Junior Specialist",
				12000, "In Progress", "10/03/2021", "10/04/2021");
		treatmentPlans.add(treatmentPlan);
		when(treatmentPlanRepository.findAll()).thenReturn(treatmentPlans);
		assertEquals(treatmentPlans, iPTreatmentServiceImpl.getAllTreatment());
	}

	/**
	 * to test treatment plan fetched all on going plans properly
	 */
	@Test
	public void testGetAllOnGoingplans() {
		List<TreatmentPlan> treatmentPlans = new ArrayList<TreatmentPlan>();
		PatientDetail patientDetail = new PatientDetail(1, "John", 26, "Arthritis", "Package2", "10/03/2021");
		TreatmentPlan treatmentPlan = new TreatmentPlan(1, patientDetail, "Test1", "Package2", "Junior Specialist",
				12000, "In Progress", "10/03/2021", "10/04/2021");
		treatmentPlans.add(treatmentPlan);
		when(treatmentPlanRepository.findOnGoingPatients()).thenReturn(treatmentPlans);
		assertEquals(treatmentPlans, iPTreatmentServiceImpl.getAllGoingTreatments());
	}

	/**
	 * to test treatment plan fetched by patient id properly
	 */
	@Test
	public void testGetPatientById() {
		PatientDetail patientDetail = new PatientDetail();
		patientDetail.setId(2);
		when(patientDetailRepository.getPatientById(2)).thenReturn(patientDetail);
		assertEquals(patientDetail.getId(), iPTreatmentServiceImpl.findPatientById(2).getId());
	}
	@Test
	public void testGetPatientByIdFailed() throws PatientNotFoundException {
		
		when(patientDetailRepository.getPatientById(2)).thenReturn(null);
		assertThrows(PatientNotFoundException.class,()-> iPTreatmentServiceImpl.findPatientById(2));
	}
	/**
	 * to test treatment plan fetched specific plan properly
	 */
	@Test
	public void testGetPlan() {
		PatientDetail patientDetail = new PatientDetail(1, "John", 26, "Arthritis", "Package2", "10/03/2021");
		TreatmentPlan treatmentPlan = new TreatmentPlan(1, patientDetail, "Test1", "Package2", "Junior Specialist",
				12000, "In Progress", "10/03/2021", "10/04/2021");
		when(treatmentPlanRepository.findByPtDetail(1)).thenReturn(treatmentPlan);
		assertEquals(treatmentPlan, iPTreatmentServiceImpl.getTreatmentPlanById(1));
	}
	@Test
	public void testGetPlanFailed() throws PatientNotFoundException {
		
		when(treatmentPlanRepository.findByPtDetail(2)).thenReturn(null);
		assertThrows(PatientNotFoundException.class,()-> iPTreatmentServiceImpl.getTreatmentPlanById(2));
	}
	/**
	 * to test treatment plan to update the status of IN progress to Completed
	 */
	@Test
	public void testUpdatePlan() {
		PatientDetail patientDetail = new PatientDetail(1, "John", 26, "Arthritis", "Package2", "10/03/2021");
		TreatmentPlan treatmentPlan = new TreatmentPlan(1, patientDetail, "Test1", "Package2", "Junior Specialist",
				12000, "In Progress", "10/03/2021", "10/04/2021");
		when(treatmentPlanRepository.findByPtDetail(1)).thenReturn(treatmentPlan);
		iPTreatmentServiceImpl.updatePlan(1);
		verify(treatmentPlanRepository, times(1)).save(treatmentPlan);
		verify(treatmentPlanRepository, times(1)).findByPtDetail(1);
		assertEquals("Completed", treatmentPlan.getStatus());
	}
	@Test
	public void testUpdatePlanFailed() throws PatientNotFoundException {
		
		when(treatmentPlanRepository.findByPtDetail(2)).thenReturn(null);
		assertThrows(PatientNotFoundException.class,()-> iPTreatmentServiceImpl.updatePlan(2));
	}
}