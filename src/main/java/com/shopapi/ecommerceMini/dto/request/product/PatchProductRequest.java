package com.shopapi.ecommerceMini.dto.request.product;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record PatchProductRequest(
        @Size(min = 1, max = 200, message = "Tên sản phẩm từ 1 đến {max} ký tự")
        @Pattern(regexp = ".*\\S.*", message = "Tên sản phẩm không được chỉ có dấu cách")
        String name,

        @Size(max = 2000, message = "Mô tả tối đa {max} ký tự")
        String description,

        @Positive(message = "Giá phải lớn hơn 0")
        @Digits(integer = 12, fraction = 0, message = "Giá phải là số nguyên, tối đa 12 chữ số")
        BigDecimal price,

        @PositiveOrZero(message = "Tồn kho không được âm")
        Integer stock,

        @Positive(message = "categoryId không hợp lệ")
        Long categoryId
) {
}
