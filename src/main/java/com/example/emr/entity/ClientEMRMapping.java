package com.example.emr.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "client_emr_mapping")
@Data
public class ClientEMRMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mapping_id", updatable = false, nullable = false)
    private Long mappingId;

    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @Column(name = "emr_id", nullable = false)
    private Long emrId;

    @Column(name = "emr_identifier", nullable = false)
    private String emrIdentifier;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "last_updated_date", nullable = false)
    private LocalDateTime lastUpdatedDate;
}
