package com.amr.project.converter;

import com.amr.project.model.dto.ItemDto;
import com.amr.project.model.dto.ShopDto;
import com.amr.project.model.entity.Coupon;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Mapper(componentModel = "spring" ,injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {ReviewMapper.class, ImageMapper.class,})
public interface ShopMapper {

    ShopDto toDTO(Shop shop);

    Shop toShop(ShopDto shopDto);

    List<Shop> toModelList(List<ShopDto> shop);

    List<ShopDto> toDTOList(List<Shop> shopDto);
}
