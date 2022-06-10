package com.amr.project.converter;

import com.amr.project.model.dto.DiscountDto;
import com.amr.project.model.entity.Discount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DiscountConverter {

    @Mapping(source = "shop.user.id", target = "userId")
    @Mapping(source = "shop.id", target = "shopId")
    DiscountDto toDto(Discount discount);

    @Mapping(source = "shop.user.id", target = "userId")
    @Mapping(source = "shop.id", target = "shopId")
    List<DiscountDto> toDtoList(List<Discount> discounts);
}
