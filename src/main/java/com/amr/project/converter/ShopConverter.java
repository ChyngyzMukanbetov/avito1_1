package com.amr.project.converter;

import com.amr.project.converter.Resolver.ShopResolver;
import com.amr.project.model.dto.*;
import com.amr.project.model.entity.Shop;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = {CouponConverter.class, CityConverter.class, ShopResolver.class, UserConverter.class,
                ReviewConverter.class, ImageConverter.class, DiscountConverter.class})
public interface ShopConverter {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "coupons", target = "couponIds")
    ShopDto toDto(Shop shop);

    @Mapping(target = "coupons", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "discounts", ignore = true)
    @Mapping(target = "user", source = "userId")
    Shop toShop(ShopDto shopDto);
}