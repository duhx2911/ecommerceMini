package com.shopapi.ecommerceMini.controller;

import com.shopapi.ecommerceMini.domain.Category;
import com.shopapi.ecommerceMini.dto.CategoryResponse;
import com.shopapi.ecommerceMini.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping
    public List<CategoryResponse> getAll(){
        return categoryService.getAll().stream()
                .map(CategoryResponse::from)
                .toList();
    }

}
