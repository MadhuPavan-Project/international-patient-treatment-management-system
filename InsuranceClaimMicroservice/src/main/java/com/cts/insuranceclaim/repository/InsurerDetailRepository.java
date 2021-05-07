package com.cts.insuranceclaim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.insuranceclaim.model.InsurerDetail;

public interface InsurerDetailRepository extends JpaRepository<InsurerDetail, Long> {

	/*
	 * returns the InsurerDetail for the specified insurer package name.
	 */
	public InsurerDetail findByInsurerPackageName(String insurerPackageName);

	/*
	 * returns the InsurerDetail for the specified insurer name.
	 */
	public InsurerDetail findByInsurerName(String insurerName);

}
