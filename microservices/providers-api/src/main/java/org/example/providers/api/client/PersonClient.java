package org.example.providers.api.client;

import org.example.providers.api.dto.PersonDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("${feign.client.implementations.person}")
public interface PersonClient {
    @RequestMapping(method = RequestMethod.GET, value = "/v1/people/{id}", produces = "application/json")
    PersonDTO get(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/v1/people/", produces = "application/json")
    List<PersonDTO> getList(@RequestParam String ids);
}
