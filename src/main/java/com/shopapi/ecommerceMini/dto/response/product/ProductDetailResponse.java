package com.shopapi.ecommerceMini.dto.response.product;

import com.shopapi.ecommerceMini.dto.response.category.CategoryResponse;

import java.math.BigDecimal;

public record ProductDetailResponse(
        Long id,
        String name,
        String description,
        BigDecimal price,
        int stock,
        CategoryResponse category
) {
}
