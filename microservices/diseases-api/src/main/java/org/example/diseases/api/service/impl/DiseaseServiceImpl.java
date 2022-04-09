package org.example.diseases.api.service.impl;

import org.example.diseases.api.dto.DiseaseDTO;
import org.example.diseases.api.model.Disease;
import org.example.diseases.api.repository.DiseaseRepository;
import org.example.diseases.api.service.DiseaseService;
import org.example.diseases.api.util.ModelMapperSingleton;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DiseaseServiceImpl implements DiseaseService {

    @Autowired
    private DiseaseRepository repository;

    @Override
    public DiseaseDTO findById(Long id) {
        Optional<Disease> optional = repository.findById(id);
        if (optional.isPresent()) {
            return ModelMapperSingleton.get().map(optional.get(), DiseaseDTO.class);
        }
        return null;
    }

    @Override
    public List<DiseaseDTO> findAllById(Long[] ids) {
        Iterable<Disease> iterable = repository.findAllById(Arrays.asList(ids));
        if (iterable != null) {
            List<Disease> list = StreamSupport.stream(iterable.spliterator(), false)
                    .collect(Collectors.toList());
            return ModelMapperSingleton.get().map(list, new TypeToken<List<DiseaseDTO>>(){}.getType());
        }
        return null;
    }
}
