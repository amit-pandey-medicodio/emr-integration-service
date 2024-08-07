package com.example.emr.service;

import com.example.emr.dto.ClientEMRMappingRequestDTO;
import com.example.emr.dto.ClientEMRMappingResponseDTO;

import java.util.List;

public interface ClientEMRMappingService {
    ClientEMRMappingResponseDTO createMapping(ClientEMRMappingRequestDTO requestDTO);
    ClientEMRMappingResponseDTO getMappingById(Long mappingId);
    List<ClientEMRMappingResponseDTO> getAllMappings();
    ClientEMRMappingResponseDTO updateMapping(Long mappingId, ClientEMRMappingRequestDTO requestDTO);
    void deleteMapping(Long mappingId);
}
