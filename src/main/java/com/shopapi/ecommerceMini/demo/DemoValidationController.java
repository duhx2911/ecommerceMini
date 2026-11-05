package com.shopapi.ecommerceMini.demo;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoValidationController {

    @PostMapping("/orders")
    public String validate(@Valid @RequestBody DemoOrderRequest request) {
        return "Hợp lệ: " + request.items().size() + " sản phẩm";
    }
}
