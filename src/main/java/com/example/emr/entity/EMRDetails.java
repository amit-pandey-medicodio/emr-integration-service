package com.example.emr.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "emr_details")
@Data
public class EMRDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emr_id", updatable = false, nullable = false)
    private Long emrId;

    @Column(name = "emr_name", nullable = false)
    private String emrName;

    @Column(name = "api_endpoint", nullable = false)
    private String apiEndpoint;

    @Column(name = "api_key", nullable = false)
    private String apiKey;

    @Column(name = "connection_details", nullable = false)
    private String connectionDetails;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "status", nullable = false)
    private String status;
}
