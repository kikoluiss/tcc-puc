package org.example.providers.api.repository;

import org.example.providers.api.model.ProviderCoverage;
import org.springframework.data.repository.CrudRepository;

public interface ProviderCoverageRepository extends CrudRepository<ProviderCoverage, Long> {

    Iterable<ProviderCoverage> findByProviderId(Long id);

}
