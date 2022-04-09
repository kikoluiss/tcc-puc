package org.example.categories.api.service.impl;

import org.example.categories.api.dto.CategoryDTO;
import org.example.categories.api.model.Category;
import org.example.categories.api.repository.CategoryRepository;
import org.example.categories.api.service.CategoryService;
import org.example.categories.api.util.ModelMapperSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public CategoryDTO findById(Long id) {
        Optional<Category> optional = repository.findById(id);
        if (optional.isPresent()) {
            return ModelMapperSingleton.get().map(optional.get(), CategoryDTO.class);
        }
        return null;
    }
}
