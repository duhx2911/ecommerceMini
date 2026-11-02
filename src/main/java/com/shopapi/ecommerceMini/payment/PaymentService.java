package com.shopapi.ecommerceMini.payment;

import java.math.BigDecimal;

public interface PaymentService {
    String pay(BigDecimal amount);
}
