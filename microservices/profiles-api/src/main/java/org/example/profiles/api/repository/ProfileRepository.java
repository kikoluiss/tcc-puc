package org.example.profiles.api.repository;

import org.example.profiles.api.model.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

}
