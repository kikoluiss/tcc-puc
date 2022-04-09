package org.example.coverages.api.service.impl;

import org.example.coverages.api.client.ShortageClient;
import org.example.coverages.api.dto.CoverageDTO;
import org.example.coverages.api.dto.ShortageDTO;
import org.example.coverages.api.model.Coverage;
import org.example.coverages.api.model.CoverageShortage;
import org.example.coverages.api.repository.CoverageRepository;
import org.example.coverages.api.repository.CoverageSortageRepository;
import org.example.coverages.api.service.CoverageService;
import org.example.coverages.api.util.ModelMapperSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CoverageServiceImpl implements CoverageService {

    @Autowired
    CoverageRepository repository;

    @Autowired
    CoverageSortageRepository relRepository;

    @Autowired
    ShortageClient shortageClient;

    @Override
    public CoverageDTO findById(Long id) {
        Optional<Coverage> optional = repository.findById(id);
        if (optional.isPresent()) {
            Coverage coverage = optional.get();

            return getCoverageDTO(coverage);
        }
        return null;
    }

    @Override
    public List<CoverageDTO> findAllById(Long[] ids) {
        Iterable<Coverage> iterable = repository.findAllById(Arrays.asList(ids));
        if (iterable != null) {
            List<Coverage> list = StreamSupport.stream(iterable.spliterator(), false)
                    .collect(Collectors.toList());

            return list.stream().map(coverage -> getCoverageDTO(coverage))
                    .collect(Collectors.toList());
        }
        return null;
    }

    private CoverageDTO getCoverageDTO(Coverage shortage) {
        List<String> shortageIds = findShortageIds(shortage.getId());
        List<ShortageDTO> shortageList  = shortageClient.getList(String.join(",", shortageIds));

        CoverageDTO coverageDTO = ModelMapperSingleton.get().map(shortage, CoverageDTO.class);
        coverageDTO.setShortages(shortageList);

        return coverageDTO;
    }

    private List<String> findShortageIds(Long id) {
        Iterable<CoverageShortage> iterable = relRepository.findByCoverageId(id);
        List<String> result = new ArrayList<>();
        iterable.forEach(i -> result.add(String.valueOf(i.getShortageId())));
        return result;
    }

}
