package com.example.emr.controller;

import com.example.emr.dto.ClientEMRMappingRequestDTO;
import com.example.emr.dto.ClientEMRMappingResponseDTO;
import com.example.emr.service.ClientEMRMappingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client-emr-mappings")
public class ClientEMRMappingController {

    @Autowired
    private ClientEMRMappingService clientEMRMappingService;
    private static final Logger logger = LoggerFactory.getLogger(ClientEMRMappingController.class);

    @PostMapping
    public ResponseEntity<ClientEMRMappingResponseDTO> createMapping(@RequestBody ClientEMRMappingRequestDTO requestDTO) {
        logger.info("Received request to create ClientEMRMapping: {}", requestDTO);
        ClientEMRMappingResponseDTO responseDTO = clientEMRMappingService.createMapping(requestDTO);
        logger.info("Successfully created ClientEMRMapping: {}", responseDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{mappingId}")
    public ResponseEntity<ClientEMRMappingResponseDTO> getMappingById(@PathVariable Long mappingId) {
        logger.info("Received request to get ClientEMRMapping by ID: {}", mappingId);
        ClientEMRMappingResponseDTO responseDTO = clientEMRMappingService.getMappingById(mappingId);
        logger.info("Successfully fetched ClientEMRMapping: {}", responseDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<ClientEMRMappingResponseDTO>> getAllMappings() {
        logger.info("Received request to get all ClientEMRMappings");
        List<ClientEMRMappingResponseDTO> responseDTOs = clientEMRMappingService.getAllMappings();
        logger.info("Successfully fetched all ClientEMRMappings");
        return ResponseEntity.ok(responseDTOs);
    }

    @PutMapping("/{mappingId}")
    public ResponseEntity<ClientEMRMappingResponseDTO> updateMapping(@PathVariable Long mappingId, @RequestBody ClientEMRMappingRequestDTO requestDTO) {
        logger.info("Received request to update ClientEMRMapping with ID: {}", mappingId);
        ClientEMRMappingResponseDTO responseDTO = clientEMRMappingService.updateMapping(mappingId, requestDTO);
        logger.info("Successfully updated ClientEMRMapping: {}", responseDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{mappingId}")
    public ResponseEntity<Void> deleteMapping(@PathVariable Long mappingId) {
        logger.info("Received request to delete ClientEMRMapping with ID: {}", mappingId);
        clientEMRMappingService.deleteMapping(mappingId);
        logger.info("Successfully deleted ClientEMRMapping with ID: {}", mappingId);
        return ResponseEntity.noContent().build();
    }
}
