package com.shopapi.ecommerceMini.dto.request.product;

import java.math.BigDecimal;

public record UpdateProductRequest(
        String name,
        String description,
        BigDecimal price,
        Integer stock,
        Long categoryId
) {
}
