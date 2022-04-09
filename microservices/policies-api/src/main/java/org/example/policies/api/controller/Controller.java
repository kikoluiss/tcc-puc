package org.example.policies.api.controller;

import org.example.policies.api.dto.PolicyDTO;
import org.example.policies.api.dto.PolicyRequestDTO;
import org.example.policies.api.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/policies")
public class Controller {

    @Autowired
    private PolicyService service;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<PolicyDTO> get(@PathVariable String id) {
        PolicyDTO dto = service.findById(id);
        return dto != null ?
                ResponseEntity.ok(dto) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, String>> createPolicy(@RequestBody @Validated PolicyRequestDTO policyRequestDTO) {
        PolicyDTO dto = service.createPolicy(policyRequestDTO);
        if (dto != null) {
            Map<String, String> result = new HashMap<>();
            result.put("id", dto.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
