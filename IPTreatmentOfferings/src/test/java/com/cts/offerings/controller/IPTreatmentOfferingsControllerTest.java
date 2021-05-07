package com.cts.offerings.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.cts.offerings.client.AuthClient;
import com.cts.offerings.model.IPTreatmentPackage;
import com.cts.offerings.model.PackageDetail;
import com.cts.offerings.model.SpecialistDetail;
import com.cts.offerings.service.IPTreatmentPackageServiceImpl;

@AutoConfigureMockMvc
@SpringBootTest
public class IPTreatmentOfferingsControllerTest {

	@MockBean
	AuthClient authClient;

	@Autowired
	MockMvc mockMvc;

	@MockBean
	IPTreatmentPackageServiceImpl ipTreatmentOfferingsServiceImpl;

	/**
	 * to test that all treatment packages are fetched properly
	 */
	@Test
	public void tesGetIPTreatmentPackages() throws Exception {
		PackageDetail packageDetail = new PackageDetail("Package1", "UTP1,UTP2", 15000, 4);
		List<IPTreatmentPackage> ipTreatmentPackages = new ArrayList<IPTreatmentPackage>();
		ipTreatmentPackages.add(new IPTreatmentPackage(1, "Urology", packageDetail));
		when(ipTreatmentOfferingsServiceImpl.getIPTreatmentPackages()).thenReturn(ipTreatmentPackages);
		when(authClient.verifyToken("Bearer Token")).thenReturn(true);
		MvcResult result = mockMvc.perform(get("/IPTreatmentPackages").header("Authorization", "Bearer Token"))
				.andReturn();
		String expected = "[{\"id\":1,\"ailmentCategory\":\"Urology\",\"packageDetail\":{\"treatmentPackageName\":\"Package1\",\"testDetails\":\"UTP1,UTP2\",\"cost\":15000,\"treatmentDuration\":4}}]";
		String actual = result.getResponse().getContentAsString();
		assertEquals(expected, actual);
	}

	/**
	 * to test the treatment packages by package name and ailment category fetched
	 * properly
	 */
	@Test
	public void testGetIPTreatmentPackageByAilmentCategoryAndName() throws Exception {
		PackageDetail packageDetail = new PackageDetail("Package1", "UTP1,UTP2", 15000, 4);
		IPTreatmentPackage ipTreatmentPackage = new IPTreatmentPackage(1, "Urology", packageDetail);
		when(ipTreatmentOfferingsServiceImpl.getTreatmentPackages("Urology", "Package1"))
				.thenReturn(ipTreatmentPackage);
		when(authClient.verifyToken("Bearer Token")).thenReturn(true);
		MvcResult result = mockMvc
				.perform(get("/IPTreatmentPackagesByName/Urology/Package1").header("Authorization", "Bearer Token"))
				.andReturn();
		String expected = "{\"id\":1,\"ailmentCategory\":\"Urology\",\"packageDetail\":{\"treatmentPackageName\":\"Package1\",\"testDetails\":\"UTP1,UTP2\",\"cost\":15000,\"treatmentDuration\":4}}";
		String actual = result.getResponse().getContentAsString();
		assertEquals(expected, actual);
	}

	/**
	 * to test that all specialists are fetched properly
	 */
	@Test
	public void testGetSpecialists() throws Exception {
		List<SpecialistDetail> specialistDetailsList = new ArrayList<SpecialistDetail>();
		specialistDetailsList.add(new SpecialistDetail(1, "Dr. AK Garg", "Orthopaedics", 12, "9876543210"));
		when(ipTreatmentOfferingsServiceImpl.getSpecialist()).thenReturn(specialistDetailsList);
		when(authClient.verifyToken("Bearer Token")).thenReturn(true);
		MvcResult result = mockMvc.perform(get("/Specialists").header("Authorization", "Bearer Token")).andReturn();
		String expected = "[{\"id\":1,\"name\":\"Dr. AK Garg\",\"areaOfExpertise\":\"Orthopaedics\",\"experienceInYears\":12,\"contactNumber\":\"9876543210\"}]";
		String actual = result.getResponse().getContentAsString();
		assertEquals(expected, actual);
	}

}