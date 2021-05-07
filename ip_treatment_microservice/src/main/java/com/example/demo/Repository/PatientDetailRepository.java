package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.PatientDetail;

public interface PatientDetailRepository extends JpaRepository<PatientDetail, Long> {

	/**
	 * returns the PatientDetail by the patient id.
	 */
	@Query("Select p from PatientDetail p where p.id =:i")
	PatientDetail getPatientById(@Param("i") long i);

	/**
	 * returns the PatientDetail by the patient name.
	 */
	@Query("Select p from PatientDetail p where p.name =:name")
	PatientDetail findByName(@Param("name") String name);

}
