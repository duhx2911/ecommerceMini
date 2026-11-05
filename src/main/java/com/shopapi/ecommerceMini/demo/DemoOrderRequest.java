package com.shopapi.ecommerceMini.demo;

import com.shopapi.ecommerceMini.validation.VietnamesePhone;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record DemoOrderRequest(
        @NotBlank(message = "Địa chỉ không được để trống") String shippingAddress,
        @NotBlank(message = "Số điện thoại không được để trống") @VietnamesePhone String phone,
        @NotEmpty(message = "Đơn hàng phải có ít nhất một sản phẩm")
        List<@Valid DemoOrderItem> items) {}
