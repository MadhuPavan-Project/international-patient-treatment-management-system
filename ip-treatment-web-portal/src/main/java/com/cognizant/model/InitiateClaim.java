package com.cognizant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InitiateClaim {

	private String patientName;
	private String ailment;
	private String treatmentPackageName;
	private String insurerName;

}
