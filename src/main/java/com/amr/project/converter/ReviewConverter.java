package com.amr.project.converter;

import com.amr.project.model.dto.ReviewDto;
import com.amr.project.model.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel="spring")
public interface ReviewConverter {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "item.id", target = "itemId")
    @Mapping(source = "user.username", target = "userName")
    @Mapping(source = "shop.id", target = "shopId")
    ReviewDto toDto(Review review);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "item.id", target = "itemId")
    @Mapping(source = "user.username", target = "userName")
    @Mapping(source = "shop.id", target = "shopId")
    List<ReviewDto> toDtoList(List<Review> reviews);
}

