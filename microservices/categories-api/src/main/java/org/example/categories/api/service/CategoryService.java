package org.example.categories.api.service;

import org.example.categories.api.dto.CategoryDTO;

public interface CategoryService {
    CategoryDTO findById(Long id);
}
