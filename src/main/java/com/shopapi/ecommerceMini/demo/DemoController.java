package com.shopapi.ecommerceMini.demo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@MyComponent
public class DemoController {
    private final DemoService service;
    public DemoController(DemoService service) { this.service = service; }
    public String handle() { return service.list(); }
    public BigDecimal getTotal(){
        return service.getTotal();
    }
    public List<String> getByPrice(){
        return service.listByPrice();
    }
    public Map<String, BigDecimal> getByCate(){
        return service.listByCate();
    }
    public String hasBulk(){
        return service.hasBulk() ? "Có" : "Không";
    }
    public Optional<OrderLine> mostExpensive(){
        return service.mostExpensive();
    }
}