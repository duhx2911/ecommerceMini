package com.shopapi.ecommerceMini.demo;

import java.math.BigDecimal;
import java.util.List;

@MyComponent
public class DemoRepository {
    public List<OrderLine> findAll() {
        return List.of(
                new OrderLine("iPhone 16", "Điện thoại", new BigDecimal("25000000"), 1),
                new OrderLine("Ốp lưng", "Phụ kiện", new BigDecimal("150000"), 3),
                new OrderLine("MacBook Air", "Laptop", new BigDecimal("28000000"), 1),
                new OrderLine("Cáp sạc", "Phụ kiện", new BigDecimal("200000"), 12),
                new OrderLine("Galaxy S25", "Điện thoại", new BigDecimal("22000000"), 2)
        );

    }
}