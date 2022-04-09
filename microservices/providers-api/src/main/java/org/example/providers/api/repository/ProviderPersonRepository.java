package org.example.providers.api.repository;

import org.example.providers.api.model.ProviderPerson;
import org.springframework.data.repository.CrudRepository;

public interface ProviderPersonRepository extends CrudRepository<ProviderPerson, Long> {

    Iterable<ProviderPerson> findByProviderId(Long id);

}
