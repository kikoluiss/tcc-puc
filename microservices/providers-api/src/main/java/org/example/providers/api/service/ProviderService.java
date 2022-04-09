package org.example.providers.api.service;

import org.example.providers.api.dto.ProviderDTO;

public interface ProviderService {
    ProviderDTO findById(Long id);
}
