package org.com.exams.api.controller;

import org.com.exams.api.dto.ExamDTO;
import org.com.exams.api.dto.ExamRequestDTO;
import org.com.exams.api.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/exams")
public class Controller {

    @Autowired
    private ExamService service;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ExamDTO> get(@PathVariable String id) {
        ExamDTO dto = service.findById(id);
        return dto != null ?
                ResponseEntity.ok(dto) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, String>> createPolicy(@RequestBody @Validated ExamRequestDTO examRequestDTO) {
        ExamDTO dto = service.register(examRequestDTO);
        if (dto != null) {
            Map<String, String> result = new HashMap<>();
            result.put("id", dto.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
