package org.example.locales.api.service.impl;

import org.example.locales.api.dto.LocaleDTO;
import org.example.locales.api.model.Locale;
import org.example.locales.api.repository.LocaleRepository;
import org.example.locales.api.service.LocaleService;
import org.example.locales.api.util.ModelMapperSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocaleServiceImpl implements LocaleService {

    @Autowired
    private LocaleRepository repository;

    @Override
    public LocaleDTO findById(Long id) {
        Optional<Locale> optional = repository.findById(id);
        if (optional.isPresent()) {
            return ModelMapperSingleton.get().map(optional.get(), LocaleDTO.class);
        }
        return null;
    }
}
