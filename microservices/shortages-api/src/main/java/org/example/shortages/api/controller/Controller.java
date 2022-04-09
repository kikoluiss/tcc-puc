package org.example.shortages.api.controller;

import org.example.shortages.api.dto.ShortageDTO;
import org.example.shortages.api.service.ShortageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/shortages")
public class Controller {

    @Autowired
    ShortageService service;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ShortageDTO> get(@PathVariable Long id) {
        ShortageDTO dto = service.findById(id);
        return dto != null ?
                ResponseEntity.ok(dto) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<ShortageDTO>> getList(@RequestParam Long[] ids) {
        List<ShortageDTO> dto = service.findAllById(ids);
        return dto != null ?
                ResponseEntity.ok(dto) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
