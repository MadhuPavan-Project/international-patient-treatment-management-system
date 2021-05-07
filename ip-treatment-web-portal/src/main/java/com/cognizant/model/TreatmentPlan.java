package com.cognizant.model;

import lombok.Data;

@Data
public class TreatmentPlan {

	private long id;
	private PatientDetail ptDetail;
	private String testDetails;
	private String packageName;
	private String specialist;
	private int cost;
	private String status;
	private String treatmentCommencementDate;
	private String treatmentEndDate;

}
