package org.example.shortages.api.service.impl;

import org.example.shortages.api.client.AgeGroupClient;
import org.example.shortages.api.client.DiseaseClient;
import org.example.shortages.api.dto.AgeGroupDTO;
import org.example.shortages.api.dto.DiseaseDTO;
import org.example.shortages.api.dto.ShortageDTO;
import org.example.shortages.api.model.Shortage;
import org.example.shortages.api.model.ShortageDisease;
import org.example.shortages.api.repository.ShortageDiseaseRepository;
import org.example.shortages.api.repository.ShortageRepository;
import org.example.shortages.api.service.ShortageService;
import org.example.shortages.api.util.ModelMapperSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ShortageServiceImpl implements ShortageService {

    @Autowired
    private ShortageRepository repository;

    @Autowired
    private ShortageDiseaseRepository relRepository;

    @Autowired
    private DiseaseClient diseaseClient;

    @Autowired
    private AgeGroupClient ageGroupClient;

    @Override
    public ShortageDTO findById(Long id) {
        Optional<Shortage> optional = repository.findById(id);
        if (optional.isPresent()) {
            Shortage shortage = optional.get();

            return getShortageDTO(shortage);
        }
        return null;
    }

    @Override
    public List<ShortageDTO> findAllById(Long[] ids) {
        Iterable<Shortage> iterable = repository.findAllById(Arrays.asList(ids));
        if (iterable != null) {
            List<Shortage> list = StreamSupport.stream(iterable.spliterator(), false)
                    .collect(Collectors.toList());

            return list.stream().map(shortage -> getShortageDTO(shortage))
                    .collect(Collectors.toList());
        }
        return null;
    }

    private ShortageDTO getShortageDTO(Shortage shortage) {
        AgeGroupDTO ageGroupDTO = null;

        List<String> diseaseIds = findDiseaseIds(shortage.getId());
        List<DiseaseDTO> diseaseList  = diseaseClient.getList(String.join(",", diseaseIds));
        if (shortage.getAgeGroupId() != null) {
            ageGroupDTO = ageGroupClient.get(shortage.getAgeGroupId());
        }

        ShortageDTO shortageDTO = ModelMapperSingleton.get().map(shortage, ShortageDTO.class);
        shortageDTO.setAgeGroup(ageGroupDTO);
        shortageDTO.setDiseases(diseaseList);

        return shortageDTO;
    }

    private List<String> findDiseaseIds(Long id) {
        Iterable<ShortageDisease> iterable = relRepository.findByShortageId(id);
        List<String> result = new ArrayList<>();
        iterable.forEach(i -> result.add(String.valueOf(i.getDiseaseId())));
        return result;
    }

}
