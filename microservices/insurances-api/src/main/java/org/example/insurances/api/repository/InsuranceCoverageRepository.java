package org.example.insurances.api.repository;

import org.example.insurances.api.model.InsuranceCoverage;
import org.springframework.data.repository.CrudRepository;

public interface InsuranceCoverageRepository extends CrudRepository<InsuranceCoverage, Long> {

    Iterable<InsuranceCoverage> findByInsuranceId(Long id);

}
