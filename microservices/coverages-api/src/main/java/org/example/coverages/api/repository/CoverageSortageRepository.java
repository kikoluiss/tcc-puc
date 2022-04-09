package org.example.coverages.api.repository;

import org.example.coverages.api.model.CoverageShortage;
import org.springframework.data.repository.CrudRepository;

public interface CoverageSortageRepository extends CrudRepository<CoverageShortage, Long> {

    Iterable<CoverageShortage> findByCoverageId(Long id);

}
