package org.example.consults.api.client;

import org.example.consults.api.dto.SpecialtyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("${feign.client.implementations.specialties}")
public interface SpecialtiesClient {
    @RequestMapping(method = RequestMethod.GET, value = "/v1/specialties/{id}", produces = "application/json")
    SpecialtyDTO get(@PathVariable Long id);
}
