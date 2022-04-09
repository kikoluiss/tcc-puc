package org.example.age.groups.api.service;

import org.example.age.groups.api.dto.AgeGroupDTO;

public interface AgeGroupService {
    AgeGroupDTO findById(Long id);
}
