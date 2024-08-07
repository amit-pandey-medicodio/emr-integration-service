package com.example.emr.service;

import com.example.emr.dto.ClientEMRMappingRequestDTO;
import com.example.emr.dto.ClientEMRMappingResponseDTO;
import com.example.emr.entity.ClientEMRMapping;
import com.example.emr.repository.ClientEMRMappingRepository;
import com.example.emr.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientEMRMappingServiceImpl implements ClientEMRMappingService {

    private final ClientEMRMappingRepository clientEMRMappingRepository;
    private static final Logger logger = LoggerFactory.getLogger(ClientEMRMappingServiceImpl.class);

    @Override
    public ClientEMRMappingResponseDTO createMapping(ClientEMRMappingRequestDTO requestDTO) {
        logger.debug("Creating ClientEMRMapping: {}", requestDTO);
        ClientEMRMapping clientEMRMapping = new ClientEMRMapping();
        clientEMRMapping.setClientId(requestDTO.getClientId());
        clientEMRMapping.setEmrId(requestDTO.getEmrId());
        clientEMRMapping.setEmrIdentifier(requestDTO.getEmrIdentifier());
        clientEMRMapping.setCreatedDate(requestDTO.getCreatedDate());
        clientEMRMapping.setLastUpdatedDate(requestDTO.getLastUpdatedDate());

        ClientEMRMapping savedClientEMRMapping = clientEMRMappingRepository.save(clientEMRMapping);
        ClientEMRMappingResponseDTO responseDTO = new ClientEMRMappingResponseDTO(savedClientEMRMapping);
        logger.debug("Created ClientEMRMapping: {}", responseDTO);
        return responseDTO;
    }

    @Override
    public ClientEMRMappingResponseDTO getMappingById(Long mappingId) {
        logger.debug("Fetching ClientEMRMapping with ID: {}", mappingId);
        ClientEMRMapping clientEMRMapping = clientEMRMappingRepository.findById(mappingId)
                .orElseThrow(() -> new ResourceNotFoundException("ClientEMRMapping not found with id: " + mappingId));
        ClientEMRMappingResponseDTO responseDTO = new ClientEMRMappingResponseDTO(clientEMRMapping);
        logger.debug("Fetched ClientEMRMapping: {}", responseDTO);
        return responseDTO;
    }

    @Override
    public List<ClientEMRMappingResponseDTO> getAllMappings() {
        logger.debug("Fetching all ClientEMRMappings");
        List<ClientEMRMappingResponseDTO> responseDTOs = clientEMRMappingRepository.findAll().stream()
                .map(ClientEMRMappingResponseDTO::new)
                .collect(Collectors.toList());
        logger.debug("Fetched all ClientEMRMappings");
        return responseDTOs;
    }

    @Override
    public ClientEMRMappingResponseDTO updateMapping(Long mappingId, ClientEMRMappingRequestDTO requestDTO) {
        logger.debug("Updating ClientEMRMapping with ID: {}", mappingId);
        ClientEMRMapping clientEMRMapping = clientEMRMappingRepository.findById(mappingId)
                .orElseThrow(() -> new ResourceNotFoundException("ClientEMRMapping not found with id: " + mappingId));

        clientEMRMapping.setClientId(requestDTO.getClientId());
        clientEMRMapping.setEmrId(requestDTO.getEmrId());
        clientEMRMapping.setEmrIdentifier(requestDTO.getEmrIdentifier());
        clientEMRMapping.setCreatedDate(requestDTO.getCreatedDate());
        clientEMRMapping.setLastUpdatedDate(requestDTO.getLastUpdatedDate());

        ClientEMRMapping updatedClientEMRMapping = clientEMRMappingRepository.save(clientEMRMapping);
        ClientEMRMappingResponseDTO responseDTO = new ClientEMRMappingResponseDTO(updatedClientEMRMapping);
        logger.debug("Updated ClientEMRMapping: {}", responseDTO);
        return responseDTO;
    }

    @Override
    public void deleteMapping(Long mappingId) {
        logger.debug("Deleting ClientEMRMapping with ID: {}", mappingId);
        ClientEMRMapping clientEMRMapping = clientEMRMappingRepository.findById(mappingId)
                .orElseThrow(() -> new ResourceNotFoundException("ClientEMRMapping not found with id: " + mappingId));
        clientEMRMappingRepository.delete(clientEMRMapping);
        logger.debug("Deleted ClientEMRMapping with ID: {}", mappingId);
    }
}
