package org.example.policies.api.service.impl;

import org.example.policies.api.client.InsurancesClient;
import org.example.policies.api.client.PeopleClient;
import org.example.policies.api.dto.InsuranceDTO;
import org.example.policies.api.dto.PersonDTO;
import org.example.policies.api.dto.PolicyDTO;
import org.example.policies.api.dto.PolicyRequestDTO;
import org.example.policies.api.model.Policy;
import org.example.policies.api.repository.PolicyRepository;
import org.example.policies.api.service.PolicyService;
import org.example.policies.api.util.ModelMapperSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    private PolicyRepository repository;

    @Autowired
    private PeopleClient peopleClient;

    @Autowired
    private InsurancesClient insurancesClient;

    @Override
    public PolicyDTO findById(String id) {
        Optional<Policy> optional = repository.findById(id);
        if (optional.isPresent()) {
            Policy policy = optional.get();

            return getPolicyDTO(policy);
        }
        return null;
    }

    @Override
    public PolicyDTO createPolicy(PolicyRequestDTO policyRequestDTO) {
        Policy policy = getPolicy(policyRequestDTO);
        policy.setId(null);
        policy.setCreatedAt(Date.valueOf(LocalDate.now()));
        policy.setUpdatedAt(Date.valueOf(LocalDate.now()));
        return getPolicyDTO(repository.save(policy));
    }

    private PolicyDTO getPolicyDTO(Policy policy) {
        PolicyDTO policyDTO = ModelMapperSingleton.get().map(policy, PolicyDTO.class);

        return policyDTO;
    }

    private Policy getPolicy(PolicyRequestDTO policyRequestDTO) {
        Policy policy = new Policy();

        InsuranceDTO insuranceDTO = insurancesClient.get(policyRequestDTO.getInsuranceId());

        List<PersonDTO> peopleDto = policyRequestDTO.getPeopleIds()
                .stream().map(id -> peopleClient.get(id))
                .collect(Collectors.toList());

        policy.setInsurance(insuranceDTO);
        policy.setPeople(peopleDto);

        return policy;
    }
}
