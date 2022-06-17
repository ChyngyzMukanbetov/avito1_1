package com.amr.project.converter;

import com.amr.project.converter.Resolver.UserResolver;
import com.amr.project.model.dto.UserDto;
import com.amr.project.model.entity.User;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {
                UserResolver.class,
                AddressConverter.class,
                ImageConverter.class,
                CouponConverter.class,
                OrderConverter.class,
                ReviewConverter.class,
                FeedbackConverter.class,
                ShopConverter.class,
                FavoriteConverter.class,
                DiscountConverter.class,
                ChatsConverter.class
        },
        builder = @Builder(disableBuilder = true)
)
public interface UserConverter {
    User toUser(Long userId);

    @Mapping(source = "address", target = "addresses")
    @Mapping(source = "images", target = "image")
    @Mapping(source = "coupons", target = "couponIds")
    @Mapping(source = "orders", target = "orderIds")
    @Mapping(source = "shops", target = "shopIds")
    @Mapping(source = "chats", target = "chatIds")
    UserDto toDto(User user);

    @Mapping(source = "address", target = "addresses")
    @Mapping(source = "images", target = "image")
    @Mapping(source = "coupons", target = "couponIds")
    @Mapping(source = "orders", target = "orderIds")
    @Mapping(source = "shops", target = "shopIds")
    @Mapping(source = "chats", target = "chatIds")
    List<UserDto> toDto(List<User> user);

    @Mapping(target = "address", ignore = true)
    @Mapping(target = "coupons", ignore = true)
    @Mapping(target = "images", ignore = true)
    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "feedbacks", ignore = true)
    @Mapping(target = "shops", ignore = true)
    @Mapping(target = "favorite", ignore = true)
    @Mapping(target = "discounts", ignore = true)
    @Mapping(target = "chats", ignore = true)
    User toModel(UserDto userDto);


    @Mapping(target = "address", ignore = true)
    @Mapping(target = "coupons", ignore = true)
    @Mapping(target = "images", ignore = true)
    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "feedbacks", ignore = true)
    @Mapping(target = "shops", ignore = true)
    @Mapping(target = "favorite", ignore = true)
    @Mapping(target = "discounts", ignore = true)
    @Mapping(target = "chats", ignore = true)
    List<User> toModel(List<UserDto> userDto);
}
