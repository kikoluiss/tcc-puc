package org.example.coverages.api.service;

import org.example.coverages.api.dto.CoverageDTO;

import java.util.List;

public interface CoverageService {
    CoverageDTO findById(Long id);
    List<CoverageDTO> findAllById(Long[] ids);
}
