package org.example.consults.api.repository;

import org.example.consults.api.model.Consult;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConsultRepository extends MongoRepository<Consult, String> {

}
