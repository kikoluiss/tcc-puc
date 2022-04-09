package org.example.profiles.api.controller;

import org.example.profiles.api.dto.ProfileDTO;
import org.example.profiles.api.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/profiles")
public class Controller {

    @Autowired
    private ProfileService service;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ProfileDTO> get(@PathVariable Long id) {
        ProfileDTO dto = service.findById(id);
        return dto != null ?
                ResponseEntity.ok(dto) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
