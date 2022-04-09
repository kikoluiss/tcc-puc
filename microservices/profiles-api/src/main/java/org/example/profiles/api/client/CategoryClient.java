package org.example.profiles.api.client;

import org.example.profiles.api.dto.CategoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("${feign.client.implementations.category}")
public interface CategoryClient {
    @RequestMapping(method = RequestMethod.GET, value = "/v1/categories/{id}", produces = "application/json")
    CategoryDTO get(@PathVariable Long id);
}
