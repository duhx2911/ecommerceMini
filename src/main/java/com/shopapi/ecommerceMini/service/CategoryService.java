package com.shopapi.ecommerceMini.service;

import com.shopapi.ecommerceMini.domain.Category;
import com.shopapi.ecommerceMini.dto.response.category.CategoryResponse;
import com.shopapi.ecommerceMini.dto.request.category.CreateCategoryRequest;
import com.shopapi.ecommerceMini.mapper.CategoryMapper;
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
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryResponse> getAll() {
        return categoryMapper.toResponses(categoryRepository.findAll());
    }
    public CategoryResponse getById(Long id){
        return categoryMapper.toResponse(findCategoryOrThrow(id));
    }
    public CategoryResponse update(Long id, CreateCategoryRequest request){
        Category category = findCategoryOrThrow(id);

        if (categoryRepository.existsByNameAndIdNot(request.name(), id)){
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Đã tồn tại: " + request.name());
        }

        category.setName(request.name());
        return categoryMapper.toResponse(categoryRepository.save(category));
    }
    public CategoryResponse create(CreateCategoryRequest request){
        if (categoryRepository.existsByName(request.name())){
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Đã tồn tại: " + request.name());
        }
        Category saved = categoryRepository.save(new Category(null, request.name()));
        return categoryMapper.toResponse(saved);
    }
    public void delete(Long id){
        Category category = findCategoryOrThrow(id);
        if (productRepository.existsByCategoryId(id)){
            throw new  ResponseStatusException(HttpStatus.CONFLICT,
                    "Category đang có sản phẩm, không thể xóa");
        }
        categoryRepository.delete(category);
    }

    public Category findCategoryOrThrow(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Không tìm thấy category " + id));
    }
}
