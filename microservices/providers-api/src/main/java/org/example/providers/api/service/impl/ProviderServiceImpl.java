package org.example.providers.api.service.impl;

import org.example.providers.api.client.CoverageClient;
import org.example.providers.api.client.PersonClient;
import org.example.providers.api.dto.CoverageDTO;
import org.example.providers.api.dto.PersonDTO;
import org.example.providers.api.dto.ProviderDTO;
import org.example.providers.api.model.Provider;
import org.example.providers.api.model.ProviderCoverage;
import org.example.providers.api.model.ProviderPerson;
import org.example.providers.api.repository.ProviderCoverageRepository;
import org.example.providers.api.repository.ProviderPersonRepository;
import org.example.providers.api.repository.ProviderRepository;
import org.example.providers.api.service.ProviderService;
import org.example.providers.api.util.ModelMapperSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderRepository repository;

    @Autowired
    private ProviderCoverageRepository relCoverageRepository;

    @Autowired
    private ProviderPersonRepository relPersonRepository;

    @Autowired
    private CoverageClient coverageClient;

    @Autowired
    private PersonClient personClient;

    @Override
    public ProviderDTO findById(Long id) {
        Optional<Provider> optional = repository.findById(id);
        if (optional.isPresent()) {
            Provider provider = optional.get();

            return getProviderDTO(provider);
        }
        return null;
    }

    private ProviderDTO getProviderDTO(Provider provider) {
        List<String> coverageIds = findCoverageIds(provider.getId());
        List<CoverageDTO> coverageList  = coverageClient.getList(String.join(",", coverageIds));

        List<String> personIds = findPersonIds(provider.getId());
        List<PersonDTO> personList = personClient.getList(String.join(",", personIds));

        ProviderDTO providerDTO = ModelMapperSingleton.get().map(provider, ProviderDTO.class);
        providerDTO.setCoverages(coverageList);
        providerDTO.setPeople(personList);

        return providerDTO;
    }

    private List<String> findCoverageIds(Long id) {
        Iterable<ProviderCoverage> iterable = relCoverageRepository.findByProviderId(id);
        List<String> result = new ArrayList<>();
        iterable.forEach(i -> result.add(String.valueOf(i.getCoverageId())));
        return result;
    }

    private List<String> findPersonIds(Long id) {
        Iterable<ProviderPerson> iterable = relPersonRepository.findByProviderId(id);
        List<String> result = new ArrayList<>();
        iterable.forEach(i -> result.add(String.valueOf(i.getPersonId())));
        return result;
    }

}
