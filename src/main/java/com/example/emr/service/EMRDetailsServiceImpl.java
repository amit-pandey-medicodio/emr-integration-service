package com.example.emr.service;

import com.example.emr.dto.EMRDetailsRequestDTO;
import com.example.emr.dto.EMRDetailsResponseDTO;
import com.example.emr.entity.EMRDetails;
import com.example.emr.repository.EMRDetailsRepository;
import com.example.emr.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EMRDetailsServiceImpl implements EMRDetailsService {

    private final EMRDetailsRepository emrDetailsRepository;
    private static final Logger logger = LoggerFactory.getLogger(EMRDetailsServiceImpl.class);

    @Override
    public EMRDetailsResponseDTO createEMRDetails(EMRDetailsRequestDTO requestDTO) {
        logger.debug("Creating EMRDetails: {}", requestDTO);
        EMRDetails emrDetails = new EMRDetails();
        emrDetails.setEmrName(requestDTO.getEmrName());
        emrDetails.setApiEndpoint(requestDTO.getApiEndpoint());
        emrDetails.setApiKey(requestDTO.getApiKey());
        emrDetails.setConnectionDetails(requestDTO.getConnectionDetails());
        emrDetails.setCreatedDate(requestDTO.getCreatedDate());
        emrDetails.setStatus(requestDTO.getStatus());

        EMRDetails savedEMRDetails = emrDetailsRepository.save(emrDetails);
        EMRDetailsResponseDTO responseDTO = new EMRDetailsResponseDTO(savedEMRDetails);
        logger.debug("Created EMRDetails: {}", responseDTO);
        return responseDTO;
    }

    @Override
    public EMRDetailsResponseDTO getEMRDetailsById(Long emrId) {
        logger.debug("Fetching EMRDetails with ID: {}", emrId);
        EMRDetails emrDetails = emrDetailsRepository.findById(emrId)
                .orElseThrow(() -> new ResourceNotFoundException("EMRDetails not found with id: " + emrId));
        EMRDetailsResponseDTO responseDTO = new EMRDetailsResponseDTO(emrDetails);
        logger.debug("Fetched EMRDetails: {}", responseDTO);
        return responseDTO;
    }

    @Override
    public List<EMRDetailsResponseDTO> getAllEMRDetails() {
        logger.debug("Fetching all EMRDetails");
        List<EMRDetailsResponseDTO> responseDTOs = emrDetailsRepository.findAll().stream()
                .map(EMRDetailsResponseDTO::new)
                .collect(Collectors.toList());
        logger.debug("Fetched all EMRDetails");
        return responseDTOs;
    }

    @Override
    public EMRDetailsResponseDTO updateEMRDetails(Long emrId, EMRDetailsRequestDTO requestDTO) {
        logger.debug("Updating EMRDetails with ID: {}", emrId);
        EMRDetails emrDetails = emrDetailsRepository.findById(emrId)
                .orElseThrow(() -> new ResourceNotFoundException("EMRDetails not found with id: " + emrId));

        emrDetails.setEmrName(requestDTO.getEmrName());
        emrDetails.setApiEndpoint(requestDTO.getApiEndpoint());
        emrDetails.setApiKey(requestDTO.getApiKey());
        emrDetails.setConnectionDetails(requestDTO.getConnectionDetails());
        emrDetails.setCreatedDate(requestDTO.getCreatedDate());
        emrDetails.setStatus(requestDTO.getStatus());

        EMRDetails updatedEMRDetails = emrDetailsRepository.save(emrDetails);
        EMRDetailsResponseDTO responseDTO = new EMRDetailsResponseDTO(updatedEMRDetails);
        logger.debug("Updated EMRDetails: {}", responseDTO);
        return responseDTO;
    }

    @Override
    public void deleteEMRDetails(Long emrId) {
        logger.debug("Deleting EMRDetails with ID: {}", emrId);
        EMRDetails emrDetails = emrDetailsRepository.findById(emrId)
                .orElseThrow(() -> new ResourceNotFoundException("EMRDetails not found with id: " + emrId));
        emrDetailsRepository.delete(emrDetails);
        logger.debug("Deleted EMRDetails with ID: {}", emrId);
    }
}
