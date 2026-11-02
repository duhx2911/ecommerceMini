package com.shopapi.ecommerceMini.service;

import com.shopapi.ecommerceMini.domain.Category;
import com.shopapi.ecommerceMini.repository.CategoryRepository;
import com.shopapi.ecommerceMini.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CategoryService(CategoryRepository categoryRepository,
                           ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }
    public List<Category> getAll(){
       return categoryRepository.findAll();
    }
    public Category getById(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Không tìm thấy category " + id));
    }
    public Category update(Long id, String newName){
        Category category = getById(id);

        if (categoryRepository.existsByNameAndIdNot(newName,id)){
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Đã tồn tại: " + newName);
        }

        category.setName(newName);
        return categoryRepository.save(category);
    }
    public Category create(String name){
        if (categoryRepository.existsByName(name)){
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Đã tồn tại: " + name);
        }
        return categoryRepository.save(new Category(null, name));
    }
    public void delete(Long id){
        Category category = getById(id);
        if (productRepository.existsByCategoryId(id)){
            throw new  ResponseStatusException(HttpStatus.CONFLICT,
                    "Category đang có sản phẩm, không thể xóa");
        }
        categoryRepository.delete(category);
    }
}
