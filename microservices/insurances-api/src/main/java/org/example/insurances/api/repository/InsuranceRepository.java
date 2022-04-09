package org.example.insurances.api.repository;

import org.example.insurances.api.model.Insurance;
import org.springframework.data.repository.CrudRepository;

public interface InsuranceRepository extends CrudRepository<Insurance, Long> {

}
