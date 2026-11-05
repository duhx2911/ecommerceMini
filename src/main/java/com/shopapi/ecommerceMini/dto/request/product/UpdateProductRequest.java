package com.shopapi.ecommerceMini.dto.request.product;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record UpdateProductRequest(
        @NotBlank(message = "Tên sản phẩm không được để trống")
        @Size(max = 200, message = "Tên sản phẩm tối đa {max} ký tự")
        String name,

        @Size(max = 2000, message = "Mô tả tối đa {max} ký tự")
        String description,

        @NotNull(message = "Giá không được để trống")
        @Positive(message = "Giá phải lớn hơn 0")
        @Digits(integer = 12, fraction = 0, message = "Giá phải là số nguyên, tối đa 12 chữ số")
        BigDecimal price,

        @NotNull(message = "Tồn kho không được để trống")
        @PositiveOrZero(message = "Tồn kho không được âm")
        Integer stock,

        @NotNull(message = "Phải chọn category")
        @Positive(message = "categoryId không hợp lệ")
        Long categoryId
) {
}
