package org.example.coverages.api.client;

import org.example.coverages.api.dto.ShortageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("${feign.client.implementations.shortage}")
public interface ShortageClient {
    @RequestMapping(method = RequestMethod.GET, value = "/v1/shortages/{id}", produces = "application/json")
    ShortageDTO get(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/v1/shortages/", produces = "application/json")
    List<ShortageDTO> getList(@RequestParam String ids);
}
