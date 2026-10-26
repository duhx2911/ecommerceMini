package com.shopapi.ecommerceMini.dto;

import com.shopapi.ecommerceMini.domain.Category;

public record CategoryResponse(Long id, String name) {
    public static CategoryResponse from(Category category){
        return new CategoryResponse(category.getId(), category.getName());
    }
}
