package org.example.age.groups.api.controller;

import org.example.age.groups.api.dto.AgeGroupDTO;
import org.example.age.groups.api.service.AgeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/age-groups")
public class Controller {

    @Autowired
    private AgeGroupService service;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<AgeGroupDTO> get(@PathVariable Long id) {
        AgeGroupDTO dto = service.findById(id);
        return dto != null ?
                ResponseEntity.ok(dto) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
