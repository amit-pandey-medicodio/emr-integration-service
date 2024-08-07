package com.example.emr.repository;

import com.example.emr.entity.ClientEMRMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientEMRMappingRepository extends JpaRepository<ClientEMRMapping, Long> {
}
