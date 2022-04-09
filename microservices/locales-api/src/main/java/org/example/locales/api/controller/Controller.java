package org.example.locales.api.controller;

import org.example.locales.api.dto.LocaleDTO;
import org.example.locales.api.service.LocaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/locales")
public class Controller {

    @Autowired
    private LocaleService service;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<LocaleDTO> get(@PathVariable Long id) {
        LocaleDTO dto = service.findById(id);
        return dto != null ?
                ResponseEntity.ok(dto) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
