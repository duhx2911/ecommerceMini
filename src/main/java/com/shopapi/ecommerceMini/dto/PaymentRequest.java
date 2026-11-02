package com.shopapi.ecommerceMini.dto;

import java.math.BigDecimal;

public record PaymentRequest(String method, BigDecimal amount) {
}
