package com.example.emr.controller;

import com.example.emr.dto.EMRDetailsRequestDTO;
import com.example.emr.dto.EMRDetailsResponseDTO;
import com.example.emr.service.EMRDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emr-details")
public class EMRDetailsController {

    @Autowired
    private EMRDetailsService emrDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(EMRDetailsController.class);

    @PostMapping
    public ResponseEntity<EMRDetailsResponseDTO> createEMRDetails(@RequestBody EMRDetailsRequestDTO requestDTO) {
        logger.info("Received request to create EMRDetails: {}", requestDTO);
        EMRDetailsResponseDTO responseDTO = emrDetailsService.createEMRDetails(requestDTO);
        logger.info("Successfully created EMRDetails: {}", responseDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{emrId}")
    public ResponseEntity<EMRDetailsResponseDTO> getEMRDetailsById(@PathVariable Long emrId) {
        logger.info("Received request to get EMRDetails by ID: {}", emrId);
        EMRDetailsResponseDTO responseDTO = emrDetailsService.getEMRDetailsById(emrId);
        logger.info("Successfully fetched EMRDetails: {}", responseDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<EMRDetailsResponseDTO>> getAllEMRDetails() {
        logger.info("Received request to get all EMRDetails");
        List<EMRDetailsResponseDTO> responseDTOs = emrDetailsService.getAllEMRDetails();
        logger.info("Successfully fetched all EMRDetails");
        return ResponseEntity.ok(responseDTOs);
    }

    @PutMapping("/{emrId}")
    public ResponseEntity<EMRDetailsResponseDTO> updateEMRDetails(@PathVariable Long emrId, @RequestBody EMRDetailsRequestDTO requestDTO) {
        logger.info("Received request to update EMRDetails with ID: {}", emrId);
        EMRDetailsResponseDTO responseDTO = emrDetailsService.updateEMRDetails(emrId, requestDTO);
        logger.info("Successfully updated EMRDetails: {}", responseDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{emrId}")
    public ResponseEntity<Void> deleteEMRDetails(@PathVariable Long emrId) {
        logger.info("Received request to delete EMRDetails with ID: {}", emrId);
        emrDetailsService.deleteEMRDetails(emrId);
        logger.info("Successfully deleted EMRDetails with ID: {}", emrId);
        return ResponseEntity.noContent().build();
    }
}
