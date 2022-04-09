package org.example.specialties.api.service;

import org.example.specialties.api.dto.SpecialtyDTO;

public interface SpecialtyService {
    SpecialtyDTO findById(Long id);
}
