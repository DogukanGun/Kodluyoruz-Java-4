package com.kodluyoruz.dogukanaligundoganhm4.controller;

import com.kodluyoruz.dogukanaligundoganhm4.model.dto.CategoryDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.dto.ProductDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.entity.Product;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.UpdateCreateCategoryRequest;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.UpdateCreateProductRequest;
import com.kodluyoruz.dogukanaligundoganhm4.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductDto createProduct(@RequestBody UpdateCreateProductRequest updateCreateProductRequest){
        return productService.createProduct(updateCreateProductRequest);
    }

    @GetMapping
    public List<ProductDto> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("{id}")
    public ProductDto getProduct(@PathVariable int id){
        return productService.getProduct(id);
    }

    @PutMapping("{id}")
    public ProductDto updateProduct(@PathVariable int id,@RequestBody UpdateCreateProductRequest updateCreateProductRequest){
        return productService.updateProduct(id,updateCreateProductRequest);
    }

}
