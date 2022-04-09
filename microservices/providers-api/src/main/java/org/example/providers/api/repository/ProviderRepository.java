package org.example.providers.api.repository;

import org.example.providers.api.model.Provider;
import org.springframework.data.repository.CrudRepository;

public interface ProviderRepository extends CrudRepository<Provider, Long> {

}
