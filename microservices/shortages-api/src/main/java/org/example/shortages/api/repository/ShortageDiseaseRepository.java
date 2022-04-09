package org.example.shortages.api.repository;

import org.example.shortages.api.model.ShortageDisease;
import org.springframework.data.repository.CrudRepository;

public interface ShortageDiseaseRepository extends CrudRepository<ShortageDisease, Long> {

    Iterable<ShortageDisease> findByShortageId(Long id);

}
