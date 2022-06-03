package com.amr.project.converter;

import com.amr.project.model.dto.ShopDto;
import com.amr.project.model.entity.Shop;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShopMapper {

    ShopMapper INSTANSE = Mappers.getMapper(ShopMapper.class);

    ShopDto toDTO(Shop shop);

    Shop toItem(ShopDto shopDto);
}
