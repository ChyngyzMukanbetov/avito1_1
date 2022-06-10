package com.amr.project.converter;

import com.amr.project.model.dto.ItemDto;
import com.amr.project.model.entity.Item;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ImageMapper.class, ReviewMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ItemMapper {

    ItemDto toDTO(Item item);

    Item toModel(ItemDto itemDto);

    List<Item> toModelList(List<ItemDto> items);

    List<ItemDto> toDTOList(List<Item> itemDto);
}
