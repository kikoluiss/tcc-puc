package org.example.age.groups.api.service.impl;

import org.example.age.groups.api.dto.AgeGroupDTO;
import org.example.age.groups.api.model.AgeGroup;
import org.example.age.groups.api.repository.AgeGroupRepository;
import org.example.age.groups.api.service.AgeGroupService;
import org.example.age.groups.api.util.ModelMapperSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgeGroupServiceImpl implements AgeGroupService {

    @Autowired
    private AgeGroupRepository repository;

    @Override
    public AgeGroupDTO findById(Long id) {
        Optional<AgeGroup> optional = repository.findById(id);
        if (optional.isPresent()) {
            return ModelMapperSingleton.get().map(optional.get(), AgeGroupDTO.class);
        }
        return null;
    }
}
