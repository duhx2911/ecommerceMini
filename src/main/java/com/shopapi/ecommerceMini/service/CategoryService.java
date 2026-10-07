package com.shopapi.ecommerceMini.service;

import com.shopapi.ecommerceMini.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
