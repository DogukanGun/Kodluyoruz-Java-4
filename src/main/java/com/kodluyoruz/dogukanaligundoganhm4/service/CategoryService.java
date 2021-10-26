package com.kodluyoruz.dogukanaligundoganhm4.service;


import com.kodluyoruz.dogukanaligundoganhm4.model.dto.CategoryDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.dto.ProductDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.entity.Category;
import com.kodluyoruz.dogukanaligundoganhm4.model.entity.Product;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.UpdateCreateCategoryRequest;
import com.kodluyoruz.dogukanaligundoganhm4.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodluyoruz.dogukanaligundoganhm4.model.mapper.CategoryMapper.CATEGORY_MAPPER;
import static com.kodluyoruz.dogukanaligundoganhm4.model.mapper.ProductMapper.PRODUCT_MAPPER;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryDto createCategory(UpdateCreateCategoryRequest updateCreateCategoryRequest){
        Category category = CATEGORY_MAPPER.createCategory(updateCreateCategoryRequest);
        return CATEGORY_MAPPER.convertToCategoryDto(categoryRepository.save(category));
    }

    public List<CategoryDto> getCategories(){
        return CATEGORY_MAPPER.convertToCategoryDtoList(categoryRepository.findAll());
    }

    public CategoryDto getCategory(int id){
        return CATEGORY_MAPPER.convertToCategoryDto(categoryRepository.findById(id).orElseThrow(()->new RuntimeException("not found")));
    }
    public List<CategoryDto> getSubCategories(int id){
        Category category = categoryRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
        return CATEGORY_MAPPER.convertToCategoryDtoList(category.getSubCategoryList());
    }

    public CategoryDto getParentCategory(int id){
        Category category = categoryRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
        return CATEGORY_MAPPER.convertToCategoryDto(category.getParentCategory());
    }

    public void deleteCategory(int id,boolean isDeleted){
        categoryRepository.deleteById(id);
    }

    public CategoryDto updateCategory(int id, UpdateCreateCategoryRequest updateCreateCategoryRequest){
        Category category = CATEGORY_MAPPER.convertToCategory(getCategory(id));

        CATEGORY_MAPPER.updateCategory(category,updateCreateCategoryRequest);
        return CATEGORY_MAPPER.convertToCategoryDto(categoryRepository.save(category));
    }


    public List<ProductDto> getProducts(int id) {
        Category category = CATEGORY_MAPPER.convertToCategory(getCategory(id));
        return PRODUCT_MAPPER.convertToProductDtoList(category.getProductList());
    }
}
