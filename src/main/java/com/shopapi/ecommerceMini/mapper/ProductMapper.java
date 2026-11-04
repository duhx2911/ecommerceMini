package com.shopapi.ecommerceMini.mapper;

import com.shopapi.ecommerceMini.domain.Product;
import com.shopapi.ecommerceMini.dto.request.product.*;
import com.shopapi.ecommerceMini.dto.response.product.*;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = CategoryMapper.class,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductMapper {
    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "categoryName", source = "category.name")
    ProductResponse toResponse(Product product);

    List<ProductResponse> toResponses(List<Product> products);

    ProductDetailResponse toDetailResponse(Product product);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    Product toEntity(CreateProductRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    void updateEntity(UpdateProductRequest request, @MappingTarget Product product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    void patchEntity(PatchProductRequest request, @MappingTarget Product product);
}
