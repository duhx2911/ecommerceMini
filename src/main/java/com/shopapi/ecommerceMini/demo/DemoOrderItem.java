package com.shopapi.ecommerceMini.demo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DemoOrderItem(
        @NotNull @Positive Long productId,
        @NotNull @Min(1) @Max(99) Integer quantity) {}
