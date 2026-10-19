package com.shopapi.ecommerceMini.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.math.BigDecimal;
import java.time.Duration;

@ConfigurationProperties(prefix = "app")
public record AppProperties(String timezone, Payment payment, Order order) {
    public record Payment(BigDecimal maxAmount) {}
    public record Order(Duration pendingTimeout) {}
}
