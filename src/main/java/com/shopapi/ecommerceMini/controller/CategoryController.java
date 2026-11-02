package com.shopapi.ecommerceMini.controller;

import com.shopapi.ecommerceMini.dto.CategoryResponse;
import com.shopapi.ecommerceMini.dto.CreateCategoryRequest;
import com.shopapi.ecommerceMini.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
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

    @GetMapping("/{id}")
    public CategoryResponse getById(@PathVariable Long id){
        return CategoryResponse.from(categoryService.getById(id));
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> create(@RequestBody CreateCategoryRequest request){
        CategoryResponse created = CategoryResponse.from(categoryService.create(request.name()));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.id())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public CategoryResponse update(@PathVariable Long id,
                                   @RequestBody CreateCategoryRequest request){
        return CategoryResponse.from(categoryService.update(id, request.name()));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        categoryService.delete(id);
    }
}
