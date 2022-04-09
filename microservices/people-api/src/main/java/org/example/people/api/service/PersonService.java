package org.example.people.api.service;

import org.example.people.api.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    PersonDTO findById(Long id);
    List<PersonDTO> findAllById(Long[] ids);
    PersonDTO updateById(Long id, PersonDTO dto);
    String findPolicyById(Long id);
}
