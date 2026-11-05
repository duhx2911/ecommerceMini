package com.shopapi.ecommerceMini.controller;

import com.shopapi.ecommerceMini.dto.request.product.CreateProductRequest;
import com.shopapi.ecommerceMini.dto.request.product.PatchProductRequest;
import com.shopapi.ecommerceMini.dto.request.product.UpdateProductRequest;
import com.shopapi.ecommerceMini.dto.response.product.ProductDetailResponse;
import com.shopapi.ecommerceMini.dto.response.product.ProductResponse;
import com.shopapi.ecommerceMini.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponse> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductDetailResponse getById(@Positive @PathVariable Long id) {
        return productService.getById(id);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody CreateProductRequest request) {
        ProductResponse created = productService.create(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(created.id()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ProductResponse update(@Positive @PathVariable Long id,
                                  @Valid @RequestBody UpdateProductRequest request) {
        return productService.update(id, request);
    }

    @PatchMapping("/{id}")
    public ProductResponse patch(@Positive @PathVariable Long id,
                                 @Valid @RequestBody PatchProductRequest request) {
        return productService.patch(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Positive @PathVariable Long id) {
        productService.delete(id);
    }
}
