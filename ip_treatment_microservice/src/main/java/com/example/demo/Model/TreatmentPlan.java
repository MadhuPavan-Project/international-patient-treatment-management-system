package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Entity indicates Spring Data JPA that it is an entity class for the
 *      application
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class TreatmentPlan {

	/**
	 * 
	 * @Id helps in defining the primary key
	 * @GeneratedValue() automatically generates id.
	 */
	@Id
	@GeneratedValue
	private long id;

	/**
	 * @ManyToOne many treatment plans can be there for a single patient
	 * @JoinColumn where ptDetails contains the value from PatientDetail entity
	 */

	@ManyToOne(targetEntity = PatientDetail.class)
	@JoinColumn(name = "tp_pt_id")
	private PatientDetail ptDetail;
	private String testDetails;
	private String packageName;
	private String specialist;
	private double cost;
	private String status;
	private String treatmentCommencementDate;
	private String treatmentEndDate;

}
