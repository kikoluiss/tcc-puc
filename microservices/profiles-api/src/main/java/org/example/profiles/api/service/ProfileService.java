package org.example.profiles.api.service;

import org.example.profiles.api.dto.ProfileDTO;

public interface ProfileService {
    ProfileDTO findById(Long id);
}
