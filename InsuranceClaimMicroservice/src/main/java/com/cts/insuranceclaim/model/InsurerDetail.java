package com.cts.insuranceclaim.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @Entity indicates Spring Data JPA that it is an entity class for the
 *      application
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "insurer_detail")
public class InsurerDetail {

	/**
	 * 
	 * @Id helps in defining the primary key
	 * @GeneratedValue() automatically generates id.
	 */
	@Id
	@GeneratedValue()
	private long id;
	private String insurerName;
	private String insurerPackageName;
	private double insuranceAmountLimit;
	private int disbursementDuration;
}
