package com.shopapi.ecommerceMini.controller;

import com.shopapi.ecommerceMini.dto.PaymentRequest;
import com.shopapi.ecommerceMini.service.CheckoutService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {
    private final CheckoutService checkoutService;

    public PaymentController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping
    public String pay(@RequestBody PaymentRequest request){
        return checkoutService.pay(request.method(),request.amount());
    }
}
