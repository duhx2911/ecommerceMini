package com.shopapi.ecommerceMini.service;

import com.shopapi.ecommerceMini.domain.Category;
import com.shopapi.ecommerceMini.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<Category> getAll(){
       return categoryRepository.findAll();
    }
}
