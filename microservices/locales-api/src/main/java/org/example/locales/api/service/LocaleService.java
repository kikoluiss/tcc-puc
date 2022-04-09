package org.example.locales.api.service;

import org.example.locales.api.dto.LocaleDTO;

public interface LocaleService {
    LocaleDTO findById(Long id);
}
