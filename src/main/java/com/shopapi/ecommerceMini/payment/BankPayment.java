package com.shopapi.ecommerceMini.payment;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;

@Service
public class BankPayment implements PaymentService{
    private final Clock clock;

    public BankPayment(Clock clock) {
        this.clock = clock;
    }

    @Override
    public String pay(BigDecimal amount) {
        return "BANK: " + amount + " at " + LocalDateTime.now(clock);
    }
}
