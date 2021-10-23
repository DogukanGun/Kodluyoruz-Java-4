package com.kodluyoruz.dogukanaligundoganhm4.model.mapper;


import com.kodluyoruz.dogukanaligundoganhm4.model.dto.ProductDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.entity.Product;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.UpdateCreateProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);

    ProductDto convertToProductDao(Product product);

    Product convertToProduct(ProductDto productDto);

    void updateProduct(@MappingTarget Product product,UpdateCreateProductRequest updateCreateProductRequest);

    List<ProductDto> convertToProductDtoList(List<Product> productList);

    Product createProduct(UpdateCreateProductRequest updateCreateProductRequest);
}
