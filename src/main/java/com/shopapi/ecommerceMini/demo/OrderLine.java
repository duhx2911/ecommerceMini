package com.shopapi.ecommerceMini.demo;

import java.math.BigDecimal;

public record OrderLine(String product, String category, BigDecimal price, int quantity) {

}
