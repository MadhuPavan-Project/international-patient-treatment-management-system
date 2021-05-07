package com.cts.offerings.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Entity indicates Spring Data JPA that it is an entity class for the
 *         application
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class IPTreatmentPackage {

	/**
	 * 
	 * @Id helps in defining the primary key
	 * @GeneratedValue() automatically generates id.
	 */
	@Id
	@GeneratedValue()
	private int id;

	private String ailmentCategory;

	@Embedded
	private PackageDetail packageDetail;

}
