package com.shopapi.ecommerceMini.payment;

import java.math.BigDecimal;
import java.util.Map;

public interface PaymentService {
    String pay(BigDecimal amount);
}
