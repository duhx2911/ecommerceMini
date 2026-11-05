package com.shopapi.ecommerceMini.dto.request.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateCategoryRequest(
        @NotBlank(message = "Tên category không được để trống")
        @Size(max = 100, message = "Tối đa {max} kí tự")
        String name) {

}
