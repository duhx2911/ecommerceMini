package com.shopapi.ecommerceMini.payment;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
@Primary
public class CodPayment implements PaymentService{
    @Override
    public String pay(BigDecimal amount) {
        return "COD: " + amount;
    }
}
