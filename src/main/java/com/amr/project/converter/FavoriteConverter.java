package com.amr.project.converter;

import com.amr.project.model.dto.FavoriteDto;
import com.amr.project.model.entity.Favorite;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        ItemMapper.class,
        ShopConverter.class,
        UserConverter.class
})
public interface FavoriteConverter {

    @Mapping(source = "user.id", target = "userId")
    FavoriteDto toDto(Favorite favorite);

}
