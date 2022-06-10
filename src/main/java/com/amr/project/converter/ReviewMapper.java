package com.amr.project.converter;

import com.amr.project.model.dto.ReviewDto;
import com.amr.project.model.entity.Review;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ReviewMapper {

    ReviewDto toDTO(Review review);
    Review toModel(ReviewDto reviewDto);
    List<Review> toModelList(List<ReviewDto> reviews);
    List<ReviewDto> toDTOList(List<Review> reviewsDto);
}
