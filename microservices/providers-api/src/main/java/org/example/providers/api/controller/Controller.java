package org.example.providers.api.controller;

import org.example.providers.api.dto.ProviderDTO;
import org.example.providers.api.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/providers")
public class Controller {

    @Autowired
    private ProviderService service;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ProviderDTO> get(@PathVariable Long id) {
        ProviderDTO dto = service.findById(id);
        return dto != null ?
                ResponseEntity.ok(dto) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
