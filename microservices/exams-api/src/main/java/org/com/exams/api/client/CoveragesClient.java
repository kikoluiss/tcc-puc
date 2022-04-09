package org.com.exams.api.client;

import org.com.exams.api.dto.CoverageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("${feign.client.implementations.coverages}")
public interface CoveragesClient {
    @RequestMapping(method = RequestMethod.GET, value = "/v1/coverages/{id}", produces = "application/json")
    CoverageDTO get(@PathVariable Long id);
}
