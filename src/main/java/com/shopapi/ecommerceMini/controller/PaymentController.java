package com.shopapi.ecommerceMini.controller;

import com.shopapi.ecommerceMini.dto.request.payment.PaymentRequest;
import com.shopapi.ecommerceMini.service.CheckoutService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {
    private final CheckoutService checkoutService;

    public PaymentController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping
    public String pay(@Valid @RequestBody PaymentRequest request){
        return checkoutService.pay(request.method(),request.amount());
    }
}
