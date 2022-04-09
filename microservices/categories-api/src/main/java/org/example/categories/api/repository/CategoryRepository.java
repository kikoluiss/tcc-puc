package org.example.categories.api.repository;

import org.example.categories.api.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
