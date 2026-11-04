package com.shopapi.ecommerceMini.dto.request.payment;

import java.math.BigDecimal;

public record PaymentRequest(String method, BigDecimal amount) {
}
