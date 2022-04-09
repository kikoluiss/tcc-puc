package org.example.policies.api.client;

import org.example.policies.api.dto.InsuranceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("${feign.client.implementations.insurances}")
public interface InsurancesClient {
    @RequestMapping(method = RequestMethod.GET, value = "/v1/insurances/{id}", produces = "application/json")
    InsuranceDTO get(@PathVariable Long id);
}
