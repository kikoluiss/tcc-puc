package org.example.shortages.api.client;

import org.example.shortages.api.dto.AgeGroupDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${feign.client.implementations.ageGroup}")
public interface AgeGroupClient {
    @RequestMapping(method = RequestMethod.GET, value = "/v1/age-groups/{id}", produces = "application/json")
    AgeGroupDTO get(@PathVariable Long id);
}
