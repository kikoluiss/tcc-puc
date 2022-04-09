package org.example.policies.api.client;

import org.example.policies.api.dto.PersonDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("${feign.client.implementations.people}")
public interface PeopleClient {
    @RequestMapping(method = RequestMethod.GET, value = "/v1/people/{id}", produces = "application/json")
    PersonDTO get(@PathVariable Long id);
}
