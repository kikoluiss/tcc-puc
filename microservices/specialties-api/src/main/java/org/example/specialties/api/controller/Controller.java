package org.example.specialties.api.controller;

import org.example.specialties.api.dto.SpecialtyDTO;
import org.example.specialties.api.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/specialties")
public class Controller {

    @Autowired
    private SpecialtyService service;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<SpecialtyDTO> get(@PathVariable Long id) {
        SpecialtyDTO dto = service.findById(id);
        return dto != null ?
                ResponseEntity.ok(dto) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
