package com.shopapi.ecommerceMini.dto.response.product;

import java.math.BigDecimal;

public record ProductResponse(
        Long id,
        String name,
        BigDecimal price,
        int stock,
        Long categoryId,
        String categoryName
) {
}
