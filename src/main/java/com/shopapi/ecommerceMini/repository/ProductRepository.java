package com.shopapi.ecommerceMini.repository;

import com.shopapi.ecommerceMini.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByCategoryId(Long categoryId);
}
