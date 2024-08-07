package com.example.emr.dto;

import java.time.LocalDateTime;

import com.example.emr.entity.ClientEMRMapping;
import lombok.Data;

@Data
public class ClientEMRMappingResponseDTO {
    private Long mappingId;
    private Long clientId;
    private Long emrId;
    private String emrIdentifier;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;

    public ClientEMRMappingResponseDTO(ClientEMRMapping clientEMRMapping) {
        this.mappingId = clientEMRMapping.getMappingId();
        this.clientId = clientEMRMapping.getClientId();
        this.emrId = clientEMRMapping.getEmrId();
        this.emrIdentifier = clientEMRMapping.getEmrIdentifier();
        this.createdDate = clientEMRMapping.getCreatedDate();
        this.lastUpdatedDate = clientEMRMapping.getLastUpdatedDate();
    }
}
