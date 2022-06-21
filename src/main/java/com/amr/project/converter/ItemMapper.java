package com.amr.project.converter;

import com.amr.project.model.dto.ItemDto;
import com.amr.project.model.entity.Item;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", uses = {ImageMapper.class, ReviewMapper.class, CategoryMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ItemMapper {

    ItemDto toDTO(Item item);

    Item toModel(ItemDto itemDto);

    List<Item> toModelList(List<ItemDto> items);

    List<ItemDto> toDTOList(List<Item> itemDto);
}
