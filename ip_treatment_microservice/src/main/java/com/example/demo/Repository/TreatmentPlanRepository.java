package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.TreatmentPlan;

public interface TreatmentPlanRepository extends JpaRepository<TreatmentPlan, Long> {

	/**
	 * returns TreatmentPlan by patient id.
	 */
	@Query("Select p from TreatmentPlan p where p.ptDetail.id =:id")
	TreatmentPlan findByPtDetail(@Param("id") long id);

	/**
	 * returns the list of TreatmentPlan of the patient whose status is "In
	 * Progress".
	 */
	@Query("Select p from TreatmentPlan p where p.status LIKE 'In progress'")
	List<TreatmentPlan> findOnGoingPatients();

}
