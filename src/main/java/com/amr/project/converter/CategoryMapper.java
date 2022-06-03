package com.amr.project.converter;

import com.amr.project.model.dto.CategoryDto;
import com.amr.project.model.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANSE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto toDTO(Category category);

    Category toItem(CategoryDto categoryDto);
}
