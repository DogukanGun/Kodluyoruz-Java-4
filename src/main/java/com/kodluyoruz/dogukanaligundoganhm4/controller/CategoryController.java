package com.kodluyoruz.dogukanaligundoganhm4.controller;


import com.kodluyoruz.dogukanaligundoganhm4.model.dto.CategoryDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.dto.ProductDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.entity.Category;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.UpdateCreateCategoryRequest;
import com.kodluyoruz.dogukanaligundoganhm4.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {

 private final CategoryService categoryService;

 @PostMapping
 public CategoryDto createCategory(@RequestBody UpdateCreateCategoryRequest updateCreateCategoryRequest){
   return categoryService.createCategory(updateCreateCategoryRequest);
 }

 @GetMapping
 public List<CategoryDto> getCategories(){
  return categoryService.getCategories();
 }

 @GetMapping("{id}/subcategories")
 public List<CategoryDto> getSubCategories(@PathVariable  int id){
  return categoryService.getSubCategories(id);
 }

 @GetMapping("{id}/parent")
 public CategoryDto getParentCategory(@PathVariable int id){
  return categoryService.getParentCategory(id);
 }

 @GetMapping("{id}/products")
 public List<ProductDto> getProducts(@PathVariable int id){
  return categoryService.getProducts(id);
 }

 @DeleteMapping("{id}")
 public void deleteCategory(@PathVariable int id,@PathVariable boolean isDeleted){
   categoryService.deleteCategory(id,isDeleted);
 }

 @PutMapping("{id}")
 public CategoryDto updateCategory(@PathVariable int id,@RequestBody UpdateCreateCategoryRequest updateCreateCategoryRequest){
  return categoryService.updateCategory(id,updateCreateCategoryRequest);
 }


}
