package org.example.coverages.api.controller;

import org.example.coverages.api.dto.CoverageDTO;
import org.example.coverages.api.service.CoverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/coverages")
public class Controller {

    @Autowired
    private CoverageService service;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CoverageDTO> get(@PathVariable Long id) {
        CoverageDTO dto = service.findById(id);
        return dto != null ?
                ResponseEntity.ok(dto) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<CoverageDTO>> getList(@RequestParam Long[] ids) {
        List<CoverageDTO> dto = service.findAllById(ids);
        return dto != null ?
                ResponseEntity.ok(dto) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
