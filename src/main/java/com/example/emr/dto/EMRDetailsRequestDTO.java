package com.example.emr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EMRDetailsRequestDTO {
    private String emrName;
    private String apiEndpoint;
    private String apiKey;
    private String connectionDetails;
    private LocalDateTime createdDate;
    private String status;
}
