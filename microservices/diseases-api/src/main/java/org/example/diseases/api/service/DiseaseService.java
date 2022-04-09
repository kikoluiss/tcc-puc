package org.example.diseases.api.service;

import org.example.diseases.api.dto.DiseaseDTO;

import java.util.List;

public interface DiseaseService {
    DiseaseDTO findById(Long id);
    List<DiseaseDTO> findAllById(Long[] ids);
}
