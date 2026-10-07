package com.shopapi.ecommerceMini.repository;

import com.shopapi.ecommerceMini.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
