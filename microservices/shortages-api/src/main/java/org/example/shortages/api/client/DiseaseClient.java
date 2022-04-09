package org.example.shortages.api.client;

import org.example.shortages.api.dto.DiseaseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${feign.client.implementations.disease}")
public interface DiseaseClient {
    @RequestMapping(method = RequestMethod.GET, value = "/v1/diseases/{id}", produces = "application/json")
    DiseaseDTO get(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/v1/diseases/", produces = "application/json")
    List<DiseaseDTO> getList(@RequestParam String ids);
}
