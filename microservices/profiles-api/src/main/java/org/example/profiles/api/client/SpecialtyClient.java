package org.example.profiles.api.client;

import org.example.profiles.api.dto.SpecialtyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("${feign.client.implementations.specialty}")
public interface SpecialtyClient {
    @RequestMapping(method = RequestMethod.GET, value = "/v1/specialties/{id}", produces = "application/json")
    SpecialtyDTO get(@PathVariable Long id);
}
