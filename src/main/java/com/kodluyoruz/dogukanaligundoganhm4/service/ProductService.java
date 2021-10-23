package com.kodluyoruz.dogukanaligundoganhm4.service;

import com.kodluyoruz.dogukanaligundoganhm4.model.dto.ProductDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.entity.Product;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.UpdateCreateProductRequest;
import com.kodluyoruz.dogukanaligundoganhm4.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodluyoruz.dogukanaligundoganhm4.model.mapper.CategoryMapper.CATEGORY_MAPPER;
import static com.kodluyoruz.dogukanaligundoganhm4.model.mapper.ProductMapper.PRODUCT_MAPPER;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDto createProduct(UpdateCreateProductRequest updateCreateProductRequest){
        Product product = PRODUCT_MAPPER.createProduct(updateCreateProductRequest);
        return PRODUCT_MAPPER.convertToProductDao(productRepository.save(product));
    }

    public List<ProductDto> getProducts(){
        return PRODUCT_MAPPER.convertToProductDtoList(productRepository.findAll());
    }

    public ProductDto getProduct(int id){
        return PRODUCT_MAPPER.convertToProductDao(productRepository.findById(id).orElseThrow(()->new RuntimeException("not found")));
    }


    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }

    public ProductDto updateProduct(int id, UpdateCreateProductRequest updateCreateProductRequest){
        Product product = PRODUCT_MAPPER.convertToProduct(getProduct(id));

        PRODUCT_MAPPER.updateProduct(product,updateCreateProductRequest);
        return PRODUCT_MAPPER.convertToProductDao(productRepository.save(product));
    }
}
