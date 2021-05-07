package com.cts.offerings.model;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PackageDetail {

	private String treatmentPackageName;
	private String testDetails;
	private int cost;
	private int treatmentDuration;
}
