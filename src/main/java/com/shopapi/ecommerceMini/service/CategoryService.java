package com.shopapi.ecommerceMini.service;

import com.shopapi.ecommerceMini.domain.Category;
import com.shopapi.ecommerceMini.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    public Category getById(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Không tìm thấy category " + id));
    }
    public Category update(Long id, String newName){
        Category category = getById(id);
        category.setName(newName);
        return categoryRepository.save(category);
    }
}
