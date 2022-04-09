package org.example.people.api.controller;

import org.example.people.api.dto.PersonDTO;
import org.example.people.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/people")
public class Controller {

    @Autowired
    private PersonService service;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<PersonDTO> get(@PathVariable Long id) {
        PersonDTO dto = service.findById(id);
        return dto != null ?
                ResponseEntity.ok(dto) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<PersonDTO>> getList(@RequestParam Long[] ids) {
        List<PersonDTO> dto = service.findAllById(ids);
        return dto != null ?
                ResponseEntity.ok(dto) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PersonDTO> update(@PathVariable Long id, @RequestBody @Validated PersonDTO personDTO) {
        PersonDTO dto = service.updateById(id, personDTO);
        return dto != null ?
                ResponseEntity.ok(dto) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/policy/{id}", produces = "application/json")
    public ResponseEntity<Map<String, String>> getList(@PathVariable Long id) {
        Map<String, String> map = new HashMap<>();
        map.put("id", service.findPolicyById(id));
        return map != null ?
                ResponseEntity.ok(map) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
