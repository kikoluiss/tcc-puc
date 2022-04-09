package org.example.consults.api.client;

import org.example.consults.api.dto.CoverageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("${feign.client.implementations.people}")
public interface PeopleClient {
    @RequestMapping(method = RequestMethod.GET, value = "/v1/people/policy/{id}", produces = "application/json")
    CoverageDTO getPolicyId(@PathVariable Long id);
}
