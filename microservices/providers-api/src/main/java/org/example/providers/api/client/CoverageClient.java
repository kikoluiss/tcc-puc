package org.example.providers.api.client;

import org.example.providers.api.dto.CoverageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("${feign.client.implementations.coverage}")
public interface CoverageClient {
    @RequestMapping(method = RequestMethod.GET, value = "/v1/coverages/{id}", produces = "application/json")
    CoverageDTO get(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/v1/coverages/", produces = "application/json")
    List<CoverageDTO> getList(@RequestParam String ids);
}
