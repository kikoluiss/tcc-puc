package org.example.insurances.api.controller;

import org.example.insurances.api.dto.InsuranceDTO;
import org.example.insurances.api.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/insurances")
public class Controller {

    @Autowired
    private InsuranceService service;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<InsuranceDTO> get(@PathVariable Long id) {
        InsuranceDTO dto = service.findById(id);
        return dto != null ?
                ResponseEntity.ok(dto) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
