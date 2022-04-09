package org.example.diseases.api.controller;

import org.example.diseases.api.dto.DiseaseDTO;
import org.example.diseases.api.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/diseases")
public class Controller {

    @Autowired
    private DiseaseService service;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<DiseaseDTO> get(@PathVariable Long id) {
        DiseaseDTO dto = service.findById(id);
        return dto != null ?
                ResponseEntity.ok(dto) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<DiseaseDTO>> getList(@RequestParam Long[] ids) {
        List<DiseaseDTO> dto = service.findAllById(ids);
        return dto != null ?
                ResponseEntity.ok(dto) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
