package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.Client.AuthClient;
import com.example.demo.Model.PatientDetail;
import com.example.demo.Model.TreatmentPlan;
import com.example.demo.Service.IPTreatmentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest
class IPTreatmentControllerTest {

	@MockBean
	AuthClient authClient;

	@Autowired
	MockMvc mockMvc;

	@MockBean
	IPTreatmentServiceImpl ipTreatmentServiceImpl;

	/**
	 * to test all the patients fetched properly
	 */

	@Test
	public void testGetAllPatients() throws Exception {
		PatientDetail patient = new PatientDetail(1l, "John", 25, "Urology", "Package1", "2021-10-03");
		List<TreatmentPlan> treatmentPlans = new ArrayList<TreatmentPlan>();
		treatmentPlans.add(new TreatmentPlan(1l, patient, "Test 1, Test 2", "Package1", "Dr. A.K Mishra", 15000,
				"In Progress", "2021-03-10", "2021-03-20"));
		when(ipTreatmentServiceImpl.getAllTreatment()).thenReturn(treatmentPlans);
		when(authClient.verifyToken("Bearer Token")).thenReturn(true);
		MvcResult result = mockMvc.perform(get("/iptms/getalltreatments").header("Authorization", "Bearer Token"))
				.andReturn();
		String expected = "[{\"id\":1,\"ptDetail\":{\"id\":1,\"name\":\"John\",\"age\":25,\"ailment\":\"Urology\",\"treatmentPackageName\":\"Package1\",\"treatmentCommencementDate\":\"2021-10-03\"},\"testDetails\":\"Test 1, Test 2\",\"packageName\":\"Package1\",\"specialist\":\"Dr. A.K Mishra\",\"cost\":15000.0,\"status\":\"In Progress\",\"treatmentCommencementDate\":\"2021-03-10\",\"treatmentEndDate\":\"2021-03-20\"}]";
		String actual = result.getResponse().getContentAsString();
		assertEquals(expected, actual);

	}

	/**
	 * to test all the on going patients fetched properly
	 */
	@Test
	public void testGetAllOnGoingPatients() throws Exception {
		PatientDetail patient = new PatientDetail(1l, "John", 25, "Urology", "Package1", "2021-10-03");
		List<TreatmentPlan> treatmentPlans = new ArrayList<TreatmentPlan>();
		treatmentPlans.add(new TreatmentPlan(1l, patient, "Test 1, Test 2", "Package1", "Dr. A.K Mishra", 15000,
				"In Progress", "2021-03-10", "2021-03-20"));
		when(ipTreatmentServiceImpl.getAllGoingTreatments()).thenReturn(treatmentPlans);
		when(authClient.verifyToken("Bearer Token")).thenReturn(true);
		MvcResult result = mockMvc
				.perform(get("/iptms/getallongoingtreatments").header("Authorization", "Bearer Token")).andReturn();
		String expected = "[{\"id\":1,\"ptDetail\":{\"id\":1,\"name\":\"John\",\"age\":25,\"ailment\":\"Urology\",\"treatmentPackageName\":\"Package1\",\"treatmentCommencementDate\":\"2021-10-03\"},\"testDetails\":\"Test 1, Test 2\",\"packageName\":\"Package1\",\"specialist\":\"Dr. A.K Mishra\",\"cost\":15000.0,\"status\":\"In Progress\",\"treatmentCommencementDate\":\"2021-03-10\",\"treatmentEndDate\":\"2021-03-20\"}]";
		String actual = result.getResponse().getContentAsString();
		assertEquals(expected, actual);

	}

	/**
	 * to test the patient fetched by patient id properly
	 */
	@Test
	public void testGetPatient() throws Exception {
		PatientDetail patient = new PatientDetail(1l, "John", 25, "Urology", "Package1", "2021-10-03");
		when(ipTreatmentServiceImpl.findPatientById(1l)).thenReturn(patient);
		when(authClient.verifyToken("Bearer Token")).thenReturn(true);
		MvcResult result = mockMvc.perform(get("/iptms/getpatient/1").header("Authorization", "Bearer Token"))
				.andReturn();
		String expected = "{\"id\":1,\"name\":\"John\",\"age\":25,\"ailment\":\"Urology\",\"treatmentPackageName\":\"Package1\",\"treatmentCommencementDate\":\"2021-10-03\"}";
		String actual = result.getResponse().getContentAsString();
		assertEquals(expected, actual);
	}

	/**
	 * to test the treatment plan fetched by treatment plan id properly
	 */
	@Test
	public void testGetAPlan() throws Exception {
		PatientDetail patient = new PatientDetail(1l, "John", 25, "Urology", "Package1", "2021-03-11");
		TreatmentPlan treatmentPlan = new TreatmentPlan(1l, patient, "Test 1, Test 2", "Package1", "Dr. A.K Mishra",
				15000.0, "In Progress", "2021-03-11", "2021-03-20");
		when(ipTreatmentServiceImpl.getTreatmentPlanById(1l)).thenReturn(treatmentPlan);
		when(authClient.verifyToken("Bearer Token")).thenReturn(true);
		MvcResult result = mockMvc.perform(get("/iptms/getplan/1").header("Authorization", "Bearer Token")).andReturn();
		String expected = "{\"id\":1,\"ptDetail\":{\"id\":1,\"name\":\"John\",\"age\":25,\"ailment\":\"Urology\",\"treatmentPackageName\":\"Package1\",\"treatmentCommencementDate\":\"2021-03-11\"},\"testDetails\":\"Test 1, Test 2\",\"packageName\":\"Package1\",\"specialist\":\"Dr. A.K Mishra\",\"cost\":15000.0,\"status\":\"In Progress\",\"treatmentCommencementDate\":\"2021-03-11\",\"treatmentEndDate\":\"2021-03-20\"}";
		String actual = result.getResponse().getContentAsString();
		assertEquals(expected, actual);
	}

	/**
	 * to test the functioning of update status
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdatePlan() throws Exception {
		PatientDetail patient = new PatientDetail(1l, "John", 25, "Urology", "Package1", "2021-03-11");
		TreatmentPlan newTreatmentPlan = new TreatmentPlan(1l, patient, "Test 1, Test 2", "Package1", "Dr. A.K Mishra",
				15000.0, "Completed", "2021-03-11", "2021-03-20");
		when(ipTreatmentServiceImpl.getTreatmentPlanById(1l)).thenReturn(newTreatmentPlan);
		when(authClient.verifyToken("Bearer Token")).thenReturn(true);
		mockMvc.perform(put("/iptms/updateplan/1").content(asJsonString(newTreatmentPlan))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer Token")).andReturn();
		MvcResult result = mockMvc.perform(get("/iptms/getplan/1").header("Authorization", "Bearer Token")).andReturn();
		String expected = "{\"id\":1,\"ptDetail\":{\"id\":1,\"name\":\"John\",\"age\":25,\"ailment\":\"Urology\",\"treatmentPackageName\":\"Package1\",\"treatmentCommencementDate\":\"2021-03-11\"},\"testDetails\":\"Test 1, Test 2\",\"packageName\":\"Package1\",\"specialist\":\"Dr. A.K Mishra\",\"cost\":15000.0,\"status\":\"Completed\",\"treatmentCommencementDate\":\"2021-03-11\",\"treatmentEndDate\":\"2021-03-20\"}";
		String actual = result.getResponse().getContentAsString();
		assertEquals(expected, actual);
	}

	/**
	 * to test the functioning of formulating treatment timetable
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFormulateTreatmentTimetable() throws Exception {
		PatientDetail patient = new PatientDetail(1l, "John", 25, "Urology", "Package1", "2021-03-11");
		TreatmentPlan treatmentPlan = new TreatmentPlan(1l, patient, "Test 1, Test 2", "Package1", "Dr. A.K Mishra",
				15000.0, "In Progress", "2021-03-11", "2021-03-20");
		when(ipTreatmentServiceImpl.getTreatmentPlan(patient, "Bearer Token")).thenReturn(treatmentPlan);
		when(authClient.verifyToken("Bearer Token")).thenReturn(true);
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/iptms/formulatetreatmenttimetable")
				.content(asJsonString(patient)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).header("Authorization", "Bearer Token")).andReturn();
		String expected = "{\"id\":1,\"ptDetail\":{\"id\":1,\"name\":\"John\",\"age\":25,\"ailment\":\"Urology\",\"treatmentPackageName\":\"Package1\",\"treatmentCommencementDate\":\"2021-03-11\"},\"testDetails\":\"Test 1, Test 2\",\"packageName\":\"Package1\",\"specialist\":\"Dr. A.K Mishra\",\"cost\":15000.0,\"status\":\"In Progress\",\"treatmentCommencementDate\":\"2021-03-11\",\"treatmentEndDate\":\"2021-03-20\"}";
		String actual = result.getResponse().getContentAsString();
		assertEquals(expected, actual);
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}