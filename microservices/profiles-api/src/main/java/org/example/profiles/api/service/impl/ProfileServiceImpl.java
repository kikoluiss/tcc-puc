package org.example.profiles.api.service.impl;

import org.example.profiles.api.client.CategoryClient;
import org.example.profiles.api.client.LocaleClient;
import org.example.profiles.api.client.SpecialtyClient;
import org.example.profiles.api.dto.CategoryDTO;
import org.example.profiles.api.dto.LocaleDTO;
import org.example.profiles.api.dto.ProfileDTO;
import org.example.profiles.api.dto.SpecialtyDTO;
import org.example.profiles.api.model.Profile;
import org.example.profiles.api.repository.ProfileRepository;
import org.example.profiles.api.service.ProfileService;
import org.example.profiles.api.util.ModelMapperSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository repository;

    @Autowired
    private CategoryClient categoryClient;

    @Autowired
    private LocaleClient localeClient;

    @Autowired
    private SpecialtyClient specialtyClient;

    @Override
    public ProfileDTO findById(Long id) {
        Optional<Profile> optional = repository.findById(id);
        if (optional.isPresent()) {
            CategoryDTO categoryDTO = null;
            LocaleDTO localeDTO = null;
            SpecialtyDTO specialtyDTO = null;

            Profile profile = optional.get();
            if (profile.getCategoryId() != null) {
                categoryDTO = categoryClient.get(profile.getCategoryId());
            }
            if (profile.getLocaleId() != null) {
                localeDTO = localeClient.get(profile.getLocaleId());
            }
            if (profile.getSpecialtyId() != null) {
                specialtyDTO = specialtyClient.get(profile.getSpecialtyId());
            }

            ProfileDTO profileDTO = ModelMapperSingleton.get().map(profile, ProfileDTO.class);

            profileDTO.setCategory(categoryDTO);
            profileDTO.setLocale(localeDTO);
            profileDTO.setSpecialty(specialtyDTO);

            return profileDTO;
        }
        return null;
    }
}
