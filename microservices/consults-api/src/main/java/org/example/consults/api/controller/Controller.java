package org.example.consults.api.controller;

import org.apache.commons.lang.StringUtils;
import org.example.consults.api.dto.ConsultDTO;
import org.example.consults.api.dto.ConsultAuthorizeDTO;
import org.example.consults.api.dto.ConsultRegisterDTO;
import org.example.consults.api.service.ConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;
import static org.apache.commons.lang.Validate.notNull;

@RestController
@RequestMapping("/v1/consults")
public class Controller {

    @Autowired
    private ConsultService service;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ConsultDTO> get(@PathVariable String id) {
        ConsultDTO dto = service.findById(id);
        return dto != null ?
                ResponseEntity.ok(dto) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping(value = "/authorize", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, String>> authorize(@RequestBody @Validated ConsultAuthorizeDTO consultAuthorizeDTO) {
        String token = service.authorize(consultAuthorizeDTO);
        if (token != null) {
            Map<String, String> result = new HashMap<>();
            result.put("protocol", token);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, String>> register(@RequestBody @Validated ConsultRegisterDTO consultRegisterDTO) {
        if (StringUtils.isNotEmpty(consultRegisterDTO.getProtocol()) && service.isValidateToken(consultRegisterDTO.getProtocol())) {
            ConsultDTO dto = service.register(consultRegisterDTO);
            if (dto != null) {
                Map<String, String> result = new HashMap<>();
                result.put("id", dto.getId());
                return ResponseEntity.status(HttpStatus.CREATED).body(result);
            }
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Invalid Protocol. Do the Authorization process again.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

}
