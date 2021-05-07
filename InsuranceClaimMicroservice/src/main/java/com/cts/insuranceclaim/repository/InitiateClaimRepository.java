package com.cts.insuranceclaim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.insuranceclaim.model.InitiateClaim;

public interface InitiateClaimRepository extends JpaRepository<InitiateClaim, Long> {

}
