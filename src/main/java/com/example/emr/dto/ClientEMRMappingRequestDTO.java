package com.example.emr.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ClientEMRMappingRequestDTO {
    private Long clientId;
    private Long emrId;
    private String emrIdentifier;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
}
