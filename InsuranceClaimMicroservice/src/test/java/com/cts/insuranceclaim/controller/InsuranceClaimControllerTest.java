package com.cts.insuranceclaim.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.cts.insuranceclaim.Client.AuthClient;
import com.cts.insuranceclaim.model.InitiateClaim;
import com.cts.insuranceclaim.model.InsurerDetail;
import com.cts.insuranceclaim.service.InsuranceClaimServiceImpl;

@AutoConfigureMockMvc
@SpringBootTest
class InsuranceClaimControllerTest {


	@Mock
	private AuthClient feignWithAuth;

	@Mock
	private InsuranceClaimServiceImpl service;
	@MockBean
	AuthClient authClient;

	@InjectMocks
	private ICMicroserviceController controller;
	@MockBean
	InsuranceClaimServiceImpl insuranceClaimServiceImpl;

	@Autowired
	MockMvc mockMvc;

	/**
	 * to test that list of all the insurer details are fetched properly
	 */
	@Test
	void testGetAllInsurerDetail() throws Exception {
		List<InsurerDetail> insurerDetailList = new ArrayList<InsurerDetail>();
		insurerDetailList.add(new InsurerDetail(1, "insurerName", "insurerPackageName", 200, 8));
		when(insuranceClaimServiceImpl.getAllInsurerDetails()).thenReturn(insurerDetailList);
		when(authClient.verifyToken("Bearer Token")).thenReturn(true);
		MvcResult result = mockMvc.perform(get("/getAllInsurerDetails").header("Authorization", "Bearer Token"))
				.andReturn();
		String expected = "[{\"id\":1,\"insurerName\":\"insurerName\",\"insurerPackageName\":\"insurerPackageName\",\"insuranceAmountLimit\":200.0,\"disbursementDuration\":8}]";
		String actual = result.getResponse().getContentAsString();

		assertEquals(expected, actual);

	}

	/**
	 * to test that an insurer detail is fetched properly
	 */
	@Test
	void testGetInsurerDetail() throws Exception {
		InsurerDetail insurer = new InsurerDetail(1l, "insurerName", "insurerPackageName", 200, 8);
		when(insuranceClaimServiceImpl.getInsurerByPackageName("insurerPackageName")).thenReturn(insurer);
		when(authClient.verifyToken("Bearer Token")).thenReturn(true);
		MvcResult result = mockMvc
				.perform(get("/getInsurerByPackageName/insurerPackageName").header("Authorization", "Bearer Token"))
				.andReturn();
		String expected = "{\"id\":1,\"insurerName\":\"insurerName\",\"insurerPackageName\":\"insurerPackageName\",\"insuranceAmountLimit\":200.0,\"disbursementDuration\":8}";
		String actual = result.getResponse().getContentAsString();
		assertEquals(expected, actual);
	}

	/**
	 * to test the functioning of initiating claim
	 */
	@Test
	void testInitiateClaim() throws Exception {

		InitiateClaim initiateClaim = new InitiateClaim(1, "John", "Arthritis", "Package2",
				"Life Insurance Corporation");
		Mockito.when(feignWithAuth.verifyToken("token")).thenReturn(true);
		Mockito.when(service.getInitiateClaim(initiateClaim, "token")).thenReturn( 100.0);
		double actualres = controller.getInitiateCliam(initiateClaim, "token");
		assertEquals(100.0, actualres);
	}

	

}