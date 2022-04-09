package org.example.insurances.api.service;

import org.example.insurances.api.dto.InsuranceDTO;

import java.util.List;

public interface InsuranceService {
    InsuranceDTO findById(Long id);
    List<InsuranceDTO> findAllById(Long[] ids);
}
