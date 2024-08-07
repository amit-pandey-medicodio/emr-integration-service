package com.example.emr.dto;

import java.time.LocalDateTime;

import com.example.emr.entity.EMRDetails;
import lombok.Data;

@Data
public class EMRDetailsResponseDTO {
    private Long emrId;
    private String emrName;
    private String apiEndpoint;
    private String apiKey;
    private String connectionDetails;
    private LocalDateTime createdDate;
    private String status;

    public EMRDetailsResponseDTO(EMRDetails emrDetails) {
        this.emrId = emrDetails.getEmrId();
        this.emrName = emrDetails.getEmrName();
        this.apiEndpoint = emrDetails.getApiEndpoint();
        this.apiKey = emrDetails.getApiKey();
        this.connectionDetails = emrDetails.getConnectionDetails();
        this.createdDate = emrDetails.getCreatedDate();
        this.status = emrDetails.getStatus();
    }
}
