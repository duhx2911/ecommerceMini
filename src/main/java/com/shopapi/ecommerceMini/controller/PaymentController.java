package com.shopapi.ecommerceMini.controller;

import com.shopapi.ecommerceMini.service.CheckoutService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final CheckoutService checkoutService;

    public PaymentController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @GetMapping("/{method}")
    public String pay(@PathVariable String method, @RequestParam BigDecimal amount){
        return checkoutService.pay(method, amount);
    }
}
