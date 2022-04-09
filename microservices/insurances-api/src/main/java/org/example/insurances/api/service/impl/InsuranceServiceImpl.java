package org.example.insurances.api.service.impl;

import org.example.insurances.api.client.CoverageClient;
import org.example.insurances.api.dto.CoverageDTO;
import org.example.insurances.api.dto.InsuranceDTO;
import org.example.insurances.api.model.Insurance;
import org.example.insurances.api.model.InsuranceCoverage;
import org.example.insurances.api.repository.InsuranceCoverageRepository;
import org.example.insurances.api.repository.InsuranceRepository;
import org.example.insurances.api.service.InsuranceService;
import org.example.insurances.api.util.ModelMapperSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    private InsuranceRepository repository;

    @Autowired
    private InsuranceCoverageRepository relRepository;

    @Autowired
    private CoverageClient coverageClient;

    @Override
    public InsuranceDTO findById(Long id) {
        Optional<Insurance> optional = repository.findById(id);
        if (optional.isPresent()) {
            Insurance insurance = optional.get();

            return getInsuranceDTO(insurance);
        }
        return null;
    }

    @Override
    public List<InsuranceDTO> findAllById(Long[] ids) {
        Iterable<Insurance> iterable = repository.findAllById(Arrays.asList(ids));
        if (iterable != null) {
            List<Insurance> list = StreamSupport.stream(iterable.spliterator(), false)
                    .collect(Collectors.toList());

            return list.stream().map(insurance -> getInsuranceDTO(insurance))
                    .collect(Collectors.toList());
        }
        return null;
    }

    private InsuranceDTO getInsuranceDTO(Insurance insurance) {
        List<String> coverageIds = findCoverageIds(insurance.getId());
        List<CoverageDTO> coverageList  = coverageClient.getList(String.join(",", coverageIds));

        InsuranceDTO insuranceDTO = ModelMapperSingleton.get().map(insurance, InsuranceDTO.class);
        insuranceDTO.setCoverages(coverageList);

        return insuranceDTO;
    }

    private List<String> findCoverageIds(Long id) {
        Iterable<InsuranceCoverage> iterable = relRepository.findByInsuranceId(id);
        List<String> result = new ArrayList<>();
        iterable.forEach(i -> result.add(String.valueOf(i.getCoverageId())));
        return result;
    }
}
