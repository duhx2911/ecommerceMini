package com.shopapi.ecommerceMini.service;

import com.shopapi.ecommerceMini.domain.Category;
import com.shopapi.ecommerceMini.domain.Product;
import com.shopapi.ecommerceMini.dto.request.product.CreateProductRequest;
import com.shopapi.ecommerceMini.dto.request.product.PatchProductRequest;
import com.shopapi.ecommerceMini.dto.request.product.UpdateProductRequest;
import com.shopapi.ecommerceMini.dto.response.product.ProductDetailResponse;
import com.shopapi.ecommerceMini.dto.response.product.ProductResponse;
import com.shopapi.ecommerceMini.mapper.ProductMapper;
import com.shopapi.ecommerceMini.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, CategoryService categoryService, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.productMapper = productMapper;
    }

    public List<ProductResponse> getAll(){
        return productMapper.toResponses(productRepository.findAll());
    }
    public ProductDetailResponse getById(Long id) {
        return productMapper.toDetailResponse(findProductOrThrow(id));
    }

    public ProductResponse create(CreateProductRequest request) {
        Product product = productMapper.toEntity(request);
        product.setCategory(categoryService.findCategoryOrThrow(request.categoryId()));
        return productMapper.toResponse(productRepository.save(product));
    }

    public ProductResponse update(Long id, UpdateProductRequest request) {
        Product product = findProductOrThrow(id);
        Category category = categoryService.findCategoryOrThrow(request.categoryId());
        productMapper.updateEntity(request, product);
        product.setCategory(category);
        return productMapper.toResponse(productRepository.save(product));
    }

    public ProductResponse patch(Long id, PatchProductRequest request) {
        Product product = findProductOrThrow(id);
        Category category = request.categoryId() != null
                ? categoryService.findCategoryOrThrow(request.categoryId())
                : null;
        productMapper.patchEntity(request, product);
        if (category != null) {
            product.setCategory(category);
        }
        return productMapper.toResponse(productRepository.save(product));
    }

    public void delete(Long id) {
        productRepository.delete(findProductOrThrow(id));
    }

    private Product findProductOrThrow(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Không tìm thấy sản phẩm " + id));
    }
}
