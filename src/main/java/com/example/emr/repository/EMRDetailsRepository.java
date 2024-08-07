package com.example.emr.repository;

import com.example.emr.entity.EMRDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EMRDetailsRepository extends JpaRepository<EMRDetails, Long> {
}
