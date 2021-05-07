package com.cts.offerings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.offerings.model.IPTreatmentPackage;

@Repository
public interface IPTreatmentPackageRepository extends JpaRepository<IPTreatmentPackage, Integer> {
	/**
	 * return the IPTreatmentPackage by package name and ailment.
	 */
	@Query("select p from IPTreatmentPackage p where p.packageDetail.treatmentPackageName=:packageName and p.ailmentCategory=:category")
	IPTreatmentPackage getByPackageNameAndAilment(@Param("packageName") String packageName,
			@Param("category") String category);

}
