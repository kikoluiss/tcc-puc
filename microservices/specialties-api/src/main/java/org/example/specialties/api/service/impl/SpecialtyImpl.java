package org.example.specialties.api.service.impl;

import org.example.specialties.api.dto.SpecialtyDTO;
import org.example.specialties.api.model.Specialty;
import org.example.specialties.api.repository.SpecialtyRepository;
import org.example.specialties.api.service.SpecialtyService;
import org.example.specialties.api.util.ModelMapperSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpecialtyImpl implements SpecialtyService {

    @Autowired
    private SpecialtyRepository repository;

    @Override
    public SpecialtyDTO findById(Long id) {
        Optional<Specialty> optional = repository.findById(id);
        if (optional.isPresent()) {
            return ModelMapperSingleton.get().map(optional.get(), SpecialtyDTO.class);
        }
        return null;
    }

}
