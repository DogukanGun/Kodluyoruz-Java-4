package com.kodluyoruz.dogukanaligundoganhm4.model.mapper;

import com.kodluyoruz.dogukanaligundoganhm4.model.dto.CategoryDto;
import com.kodluyoruz.dogukanaligundoganhm4.model.entity.Category;
import com.kodluyoruz.dogukanaligundoganhm4.model.request.UpdateCreateCategoryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper CATEGORY_MAPPER = Mappers.getMapper(CategoryMapper.class);
     CategoryDto convertToCategoryDto(Category category);

    Category convertToCategory(CategoryDto categoryDto);

    List<CategoryDto> convertToCategoryDtoList(List<Category> categories);

    Category createCategory(UpdateCreateCategoryRequest updateCreateCategoryRequest);

    void updateCategory(@MappingTarget Category category,UpdateCreateCategoryRequest updateCreateCategoryRequest);

}
