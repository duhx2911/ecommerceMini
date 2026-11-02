package com.shopapi.ecommerceMini.service;

import com.shopapi.ecommerceMini.domain.Category;
import com.shopapi.ecommerceMini.dto.CreateCategoryRequest;
import com.shopapi.ecommerceMini.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

        if (categoryRepository.existsByNameAndIdNot(newName,id)){
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Đã tồn tại: " + newName);
        }

        category.setName(newName);
        return categoryRepository.save(category);
    }
    public Category create(String name){
        if (categoryRepository.existsByName(name)){
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Đã tồn tại: " + name);
        }
        return categoryRepository.save(new Category(null, name));
    }
    public void delete(Long id){
        Category category = getById(id);
        categoryRepository.delete(category);
    }
}
