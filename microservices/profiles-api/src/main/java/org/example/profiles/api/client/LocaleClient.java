package org.example.profiles.api.client;

import org.example.profiles.api.dto.LocaleDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("${feign.client.implementations.locale}")
public interface LocaleClient {
    @RequestMapping(method = RequestMethod.GET, value = "/v1/locales/{id}", produces = "application/json")
    LocaleDTO get(@PathVariable Long id);
}
