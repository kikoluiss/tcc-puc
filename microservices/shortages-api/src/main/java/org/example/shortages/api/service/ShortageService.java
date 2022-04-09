package org.example.shortages.api.service;

import org.example.shortages.api.dto.ShortageDTO;

import java.util.List;

public interface ShortageService {
    ShortageDTO findById(Long id);
    List<ShortageDTO> findAllById(Long[] ids);
}
