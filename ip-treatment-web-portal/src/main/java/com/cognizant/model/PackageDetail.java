package com.cognizant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PackageDetail {

	private String treatmentPackageName;
	private String testDetails;
	private int cost;
	private int treatmentDuration;

	@Override
	public String toString() {
		return "PackageDetail [treatmentPackageName=" + treatmentPackageName + ", testDetail=" + testDetails + ", cost="
				+ cost + ", treatmentDurationinWeeks=" + treatmentDuration + "]";
	}

}