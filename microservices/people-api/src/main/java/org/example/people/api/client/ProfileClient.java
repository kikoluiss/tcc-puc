package org.example.people.api.client;

import org.example.people.api.dto.ProfileDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("${feign.client.implementations.profile}")
public interface ProfileClient {
    @RequestMapping(method = RequestMethod.GET, value = "/v1/profiles/{id}", produces = "application/json")
    ProfileDTO get(@PathVariable Long id);
}
