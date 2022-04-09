package org.example.shortages.api.repository;

import org.example.shortages.api.model.Shortage;
import org.springframework.data.repository.CrudRepository;

public interface ShortageRepository extends CrudRepository<Shortage, Long> {

}
