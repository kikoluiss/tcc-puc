package org.example.categories.api.controller;

import org.example.categories.api.dto.CategoryDTO;
import org.example.categories.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/categories")
public class Controller {

    @Autowired
    private CategoryService service;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<CategoryDTO> get(@PathVariable Long id) {
        CategoryDTO dto = service.findById(id);
        return dto != null ?
                ResponseEntity.ok(dto) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
