package com.shopapi.ecommerceMini.dev;

import com.shopapi.ecommerceMini.domain.Category;
import com.shopapi.ecommerceMini.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevDataSeeder implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DevDataSeeder.class);
    private final CategoryRepository categoryRepository;

    public DevDataSeeder(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {
        if (categoryRepository.count() == 0) {
            categoryRepository.save(new Category(null, "Điện thoại"));
            categoryRepository.save(new Category(null, "Laptop"));
            log.info("Đã tạo dữ liệu mẫu cho dev");
        }
    }
}