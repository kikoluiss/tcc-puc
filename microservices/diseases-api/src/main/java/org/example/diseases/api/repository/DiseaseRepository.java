package org.example.diseases.api.repository;

import org.example.diseases.api.model.Disease;
import org.springframework.data.repository.CrudRepository;

public interface DiseaseRepository extends CrudRepository<Disease, Long> {

}
