package com.example.emr.service;

import com.example.emr.dto.EMRDetailsRequestDTO;
import com.example.emr.dto.EMRDetailsResponseDTO;

import java.util.List;

public interface EMRDetailsService {
    EMRDetailsResponseDTO createEMRDetails(EMRDetailsRequestDTO requestDTO);
    EMRDetailsResponseDTO getEMRDetailsById(Long emrId);
    List<EMRDetailsResponseDTO> getAllEMRDetails();
    EMRDetailsResponseDTO updateEMRDetails(Long emrId, EMRDetailsRequestDTO requestDTO);
    void deleteEMRDetails(Long emrId);
}
