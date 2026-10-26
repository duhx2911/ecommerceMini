package com.shopapi.ecommerceMini.demo;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@MyComponent
public class DemoService {
    private final DemoRepository repository;

    public DemoService(DemoRepository repository) {
        this.repository = repository;
    }
    public String list(){ return "Danh sách: " + repository.findAll(); }
    public BigDecimal getTotal(){
        return repository.findAll().stream()
                .map(l -> l.price().multiply(BigDecimal.valueOf(l.quantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    public List<String> listByPrice(){
        return repository.findAll().stream()
                .filter(l -> l.price().compareTo(new BigDecimal("1000000")) > 0)
                .sorted(Comparator.comparing(OrderLine::price).reversed())
                .map(OrderLine::product)
                .toList();
    }
    public Map<String, BigDecimal> listByCate(){
        return repository.findAll().stream()
                .collect(Collectors.groupingBy(
                        OrderLine::category,
                        Collectors.reducing(BigDecimal.ZERO,
                               l -> l.price().multiply(BigDecimal.valueOf(l.quantity())),
                                BigDecimal::add)));
    }
    public boolean hasBulk(){
        return repository.findAll().stream().anyMatch(l -> l.quantity() > 10);
    }
    public Optional<OrderLine> mostExpensive(){
        return repository.findAll().stream()
                .max(Comparator.comparing(OrderLine::price));
    }
}
