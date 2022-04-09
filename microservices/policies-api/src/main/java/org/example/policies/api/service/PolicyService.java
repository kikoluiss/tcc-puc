package org.example.policies.api.service;

import org.example.policies.api.dto.PolicyDTO;
import org.example.policies.api.dto.PolicyRequestDTO;

public interface PolicyService {
    PolicyDTO findById(String id);
    PolicyDTO createPolicy(PolicyRequestDTO policyRequestDTO);
}
