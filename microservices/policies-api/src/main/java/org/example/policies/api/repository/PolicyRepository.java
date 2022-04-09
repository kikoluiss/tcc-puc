package org.example.policies.api.repository;

import org.example.policies.api.model.Policy;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PolicyRepository extends MongoRepository<Policy, String> {
}
